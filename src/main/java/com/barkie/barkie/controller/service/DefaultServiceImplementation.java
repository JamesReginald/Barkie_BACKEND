package com.barkie.barkie.controller.service;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * This awesome class is made by Joshua
 * @param <T> Generic class to persist the objects to the database
 */
public class DefaultServiceImplementation<T> {

    /** CrudRepository object to persist object to the database */
    private CrudRepository crudRepository;

    DefaultServiceImplementation(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    /**
     * This method can be used to retrieve an object from an id
     * @param id Long
     * @return generic object based on the id argument
     */
    public T getFromId(Long id) {
        Optional<T> optional = crudRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * This method can be used to persist an object to the database
     * @param object T
     * @return generic object
     */
    public T save(T object) {
        return (T) crudRepository.save(object);
    }

    /**
     * This method can be used to retrieve all objects of an entity
     * @return Iterable containing all objects of an entity
     */
    public Iterable<T> getAll() {
        return crudRepository.findAll();
    }
}
