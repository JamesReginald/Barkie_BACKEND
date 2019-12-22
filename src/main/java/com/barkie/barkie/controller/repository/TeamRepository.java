package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeamRepository extends CrudRepository<Team, Long> {

}
