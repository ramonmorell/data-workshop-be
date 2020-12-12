/**
 * 
 */
package com.dataworkshop.dataworkshopus.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshopus.dto.UserDTO;

/**
 * @author ramon
 *
 */
@RestController
public interface IUserCtrl {
	
	@PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> saveUser(@RequestBody(required = false) UserDTO user);
	
	@GetMapping(value="/user/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUser(@PathVariable("name") String name);

	@GetMapping(value="/userAuth/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUserAuth(@PathVariable("name") String name);
	
}
