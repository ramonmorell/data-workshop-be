/**
 * 
 */
package com.dataworkshop.dataworkshopus.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataworkshop.dataworkshopus.entity.Role;
import com.dataworkshop.dataworkshopus.entity.User;
import com.dataworkshop.dataworkshopus.enums.RoleNames;
import com.dataworkshop.dataworkshopus.repository.RoleRepository;
import com.dataworkshop.dataworkshopus.repository.UserRepository;

/**
 * @author ramon
 *
 */
@Service
@Transactional
public class UserSrv implements IUserSrv {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User finsUserByname(String name) throws Exception {
		return userRepository.findByName(name).get();
	}

	@Override
	public User saveUser(User user) throws Exception {
		user.setDateRegistry(LocalDateTime.now());
		user.setEnabled(true);
		Role role = roleRepository.findByName(RoleNames.ROLE_USER).get();
		user.getRoles().add(role);
		User _user = userRepository.save(user);
		return _user;
	}
	
}
