package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Weddenschap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddenschapRepository extends CrudRepository<Weddenschap, Long> {

}
