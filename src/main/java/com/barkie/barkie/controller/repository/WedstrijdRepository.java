package com.barkie.barkie.controller.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.barkie.barkie.domein.Wedstrijd;
import org.springframework.stereotype.Component;

@Component
public interface WedstrijdRepository extends CrudRepository<Wedstrijd, Long> {
	List<Wedstrijd> findByBeginTijdAfter(LocalDateTime nu);
}
