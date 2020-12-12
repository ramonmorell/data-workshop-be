/**
 * 
 */
package com.dataworkshop.dataworkshop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author ramon
 *
 */
@Component
public class CreateUsersExamplePasswords implements CommandLineRunner {
	
	@Autowired
	BCryptPasswordEncoder passwordEnconder;

	@Override
	public void run(String... args) throws Exception {
//		String password = "password";
//		
//		for (int i = 0; i < 4; i++) {
//			String passwordBCrypt = passwordEnconder.encode(password);
//			System.out.println(passwordBCrypt);
//		}
	}
}
