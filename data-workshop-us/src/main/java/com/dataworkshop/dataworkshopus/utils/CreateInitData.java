/**
 * 
 */
package com.dataworkshop.dataworkshopus.utils;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dataworkshop.dataworkshopus.entity.Role;
import com.dataworkshop.dataworkshopus.entity.User;
import com.dataworkshop.dataworkshopus.enums.RoleNames;
import com.dataworkshop.dataworkshopus.repository.RoleRepository;
import com.dataworkshop.dataworkshopus.repository.UserRepository;

/**
 * @author ramon
 *
 */
@Component
public class CreateInitData implements CommandLineRunner {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public void run(String... args) throws Exception {
		Role roleAdmin = new Role(RoleNames.ROLE_ADMIN);
		Role roleUser = new Role(RoleNames.ROLE_USER);
		roleRepository.save(roleAdmin);
		roleRepository.save(roleUser);
		// Just for training
		createUsersExample();
	}
	/**
	 * Just for training
	 * Create example users
	 */
	private void createUsersExample () {
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setEmail("admin@admin.com");
		userAdmin.setCountry("es");
		userAdmin.setPassword("$2a$10$XfYdTcvTQjS8D3.VBybI0.FyyG9NPkPp6QUFYmV2jb0BtJX5qSOda");
		userAdmin.setDateRegistry(LocalDateTime.now());
		userAdmin.setEnabled(true);
		Role roleAdmin = roleRepository.findByName(RoleNames.ROLE_ADMIN).get();
		userAdmin.getRoles().add(roleAdmin);
		userRepository.save(userAdmin);
		
		User userUser = new User();
		userUser.setName("user");
		userUser.setEmail("user@user.com");
		userUser.setCountry("es");
		userUser.setPassword("$2a$10$POBoyXJMR5GQDropDq65.OZlFAO8PS3VBxG7bZuJSenUd0WM1PRJS");
		userUser.setDateRegistry(LocalDateTime.now());
		userUser.setEnabled(true);
		Role roleUser = roleRepository.findByName(RoleNames.ROLE_USER).get();
		userUser.getRoles().add(roleUser);
		userRepository.save(userAdmin);
		
	}
}
