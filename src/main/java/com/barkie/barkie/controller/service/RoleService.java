package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.RoleRepository;
import com.barkie.barkie.domein.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends DefaultService<Role> {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        return roleRepository.getRoleByName(name);
    }

}
