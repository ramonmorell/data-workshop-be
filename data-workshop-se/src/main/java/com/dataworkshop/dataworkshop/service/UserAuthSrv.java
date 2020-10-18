/**
 * 
 */
package com.dataworkshop.dataworkshop.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshop.entity.User;

/**
 * @author ramon
 *
 */
@Service
public class UserAuthSrv implements UserDetailsService {
	
	private Logger log = LoggerFactory.getLogger(UserAuthSrv.class);

	@Autowired
	private IUserSrv userSrv;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Entering in loadUserByUsername with user " + username);
		
		try {
			User user = userSrv.finsUserByname(username);
			log.info("User found " + user.getName());
			
			Set<GrantedAuthority> authorities = user.getRoles()
					.stream()
					.map(role -> new SimpleGrantedAuthority(role.getName().toString()))
					.peek(authority -> log.info("Role "+ authority.getAuthority()))
					.collect(Collectors.toSet());

			return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true,
					true, true, true, authorities);
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found: " + username);
		}
	}

}
