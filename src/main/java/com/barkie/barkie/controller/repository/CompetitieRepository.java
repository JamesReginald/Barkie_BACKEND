package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Competitie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompetitieRepository extends CrudRepository<Competitie, Long> {
}
