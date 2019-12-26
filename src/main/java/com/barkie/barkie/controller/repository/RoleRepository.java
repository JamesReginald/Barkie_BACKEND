package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role getRoleByName(String name);
}
