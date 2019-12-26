package com.barkie.barkie.config.security;

import com.barkie.barkie.controller.service.GebruikerService;
import com.barkie.barkie.domein.Gebruiker;
import com.barkie.barkie.domein.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service("UserDetailsService")
public class MyUserDetailService implements UserDetailsService {

    final Logger log = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    private GebruikerService userService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Gebruiker gebruiker = userService.getGebruikerFromNaam(username);

        if (gebruiker == null){
            log.info("Reject {}, user does not exist", gebruiker);
            throw new UsernameNotFoundException("User does not exist");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : gebruiker.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(gebruiker.getUsername(), gebruiker.getPassword(), grantedAuthorities);
    }

}
