/**
 * 
 */
package com.dataworkshop.dataworkshop.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataworkshop.dataworkshop.entity.Role;
import com.dataworkshop.dataworkshop.entity.User;
import com.dataworkshop.dataworkshop.enums.RoleNames;
import com.dataworkshop.dataworkshop.repository.RoleRepository;
import com.dataworkshop.dataworkshop.repository.UserRepository;

import javassist.NotFoundException;

/**
 * @author ramon
 *
 */
@Service
@Transactional
public class UserSrv implements IUserSrv {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

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

	@Override
	public User autheticate(User user) throws Exception {
		User _user;
		try {
			_user = userRepository.findByName(user.getName()).get();
			if (_user.getPassword().equals(user.getPassword())) {
				return _user;
			} else {
				throw new NotFoundException("Invalid password");
			}
		} catch (NoSuchElementException e) {
			throw new NotFoundException("Invalid password");
		} 
	}
}
