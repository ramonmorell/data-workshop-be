/**
 * 
 */
package com.dataworkshop.dataworkshopus.controller;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.dataworkshop.dataworkshopus.dto.RoleDTO;
import com.dataworkshop.dataworkshopus.dto.UserDTO;
import com.dataworkshop.dataworkshopus.entity.Role;
import com.dataworkshop.dataworkshopus.entity.User;
import com.dataworkshop.dataworkshopus.service.UserSrv;
import com.dataworkshop.dataworkshopus.utils.UserMapper;

/**
 * @author ramon
 *
 */
@RestController
public class UserCtrl implements IUserCtrl {

	@Autowired
	private UserSrv userSrv;
	
	@Autowired
	UserMapper userMapper;

	@Override
	public ResponseEntity<UserDTO> saveUser(UserDTO user) {
		try {
			User _user = userSrv.saveUser(userMapper.mapUserDTOToUser(user));
			_user.setPassword("");
			return new ResponseEntity<UserDTO>(userMapper.mapUserToUserDTO(_user), HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<UserDTO> getUser(String name) {
		try {
			User _user = userSrv.finsUserByname(name);
			_user.setPassword("");
			return new ResponseEntity<UserDTO>(userMapper.mapUserToUserDTO(_user), HttpStatus.CREATED);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<UserDTO> getUserAuth(String name) {
		try {
			User _user = userSrv.finsUserByname(name);
			return new ResponseEntity<UserDTO>(userMapper.mapUserToUserDTO(_user), HttpStatus.CREATED);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
