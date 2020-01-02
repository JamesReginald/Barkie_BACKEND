package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Aanvraag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AanvraagRepository extends CrudRepository<Aanvraag, Long> {

    List<Aanvraag> getAllByGebruiker_Id(Long id);

}
