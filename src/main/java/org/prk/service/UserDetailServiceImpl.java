package org.prk.service;

import org.prk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prsekar on 1/3/2016.
 */
@Repository("userDetailService")
public class UserDetailServiceImpl implements UserDetailService,UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("Getting access details from employee dao !!");

        // Ideally it should be fetched from database and populated instance of
        // #org.springframework.security.core.userdetails.User should be returned from this method
        User userFromDB =  userService.getUserByUserName(s);
        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>(1);
        auth.add(new SimpleGrantedAuthority(userFromDB.getRole()));
        UserDetails user = new org.springframework.security.core.userdetails.User(userFromDB.getUsername(), userFromDB.getPassword(), true, true, true, true,auth);
        return user;
    }
}
