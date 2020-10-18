/**
 * 
 */
package com.dataworkshop.dataworkshopus.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dataworkshop.dataworkshopus.entity.Role;
import com.dataworkshop.dataworkshopus.enums.RoleNames;
import com.dataworkshop.dataworkshopus.repository.RoleRepository;

/**
 * @author ramon
 *
 */
@Component
public class CreateRoles implements CommandLineRunner {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		Role roleAdmin = new Role(RoleNames.ROLE_ADMIN);
		Role roleUser = new Role(RoleNames.ROLE_USER);
		roleRepository.save(roleAdmin);
		roleRepository.save(roleUser);
	}
}
