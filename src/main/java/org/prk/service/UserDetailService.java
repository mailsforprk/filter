package org.prk.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by prsekar on 1/3/2016.
 */
public interface UserDetailService {
     UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
