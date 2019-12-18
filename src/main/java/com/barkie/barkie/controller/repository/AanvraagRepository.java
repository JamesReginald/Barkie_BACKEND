package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Aanvraag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AanvraagRepository extends CrudRepository<Aanvraag, Long> {

}
