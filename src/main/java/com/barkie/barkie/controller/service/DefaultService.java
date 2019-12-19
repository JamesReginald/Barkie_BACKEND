package com.barkie.barkie.controller.service;

public interface DefaultService<T> {

    /**
     * This method can be used to retrieve an object from an id
     * @param id Long
     * @return generic object based on the id argument
     */
    T getFromId(Long id);

    /**
     * This method can be used to persist an object to the database
     * @param object T
     * @return generic object
     */
    T save(T object);

    /**
     * This method can be used to retrieve all objects of an entity
     * @return Iterable containing all objects of an entity
     */
    Iterable<T> getAll();
}
