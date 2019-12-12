package com.barkie.barkie.controller;

import org.springframework.data.repository.CrudRepository;
import com.barkie.barkie.domein.Wedstrijd;
import org.springframework.stereotype.Component;

@Component
public interface WedstrijdRepository extends CrudRepository<Wedstrijd, Long> {

}
