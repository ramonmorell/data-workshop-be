/**
 * 
 */
package com.dataworkshop.dataworkshop.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshop.entity.User;

/**
 * @author ramon
 *
 */
@RestController
public interface IUserCtrl {

	@PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveUser(@RequestBody(required = false) User user);
	
	@PostMapping(value="/authenticate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> authenticateUser(@RequestBody(required = false) User user);
}
