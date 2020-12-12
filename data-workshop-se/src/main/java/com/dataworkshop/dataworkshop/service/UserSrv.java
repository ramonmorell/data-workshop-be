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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshop.client.UserFeignClient;
import com.dataworkshop.dataworkshop.dto.UserDTO;

/**
 * @author ramon
 *
 */
@Service
public class UserSrv implements UserDetailsService {
	
	private Logger log = LoggerFactory.getLogger(UserSrv.class);

	@Autowired
	private UserFeignClient userSrv;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Entering in loadUserByUsername with user " + username);
		try {
			UserDTO user = userSrv.finsUserByname(username);
			log.info("loadUserByUsername => User found " + user.getName());
			
			Set<GrantedAuthority> authorities = user.getRoles()
					.stream()
					.map(role -> new SimpleGrantedAuthority(role.getName().toString()))
					.peek(authority -> log.info("Role "+ authority.getAuthority()))
					.collect(Collectors.toSet());

			return new User(user.getName(), user.getPassword(), true,
					true, true, true, authorities);
		} catch (Exception e) {
			log.error("loadUserByUsername => User not found: " + username);
			throw new UsernameNotFoundException("User not found: " + username);
		}
	}

}
