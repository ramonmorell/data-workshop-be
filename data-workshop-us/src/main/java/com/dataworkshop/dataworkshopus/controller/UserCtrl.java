/**
 * 
 */
package com.dataworkshop.dataworkshopus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshopus.entity.User;
import com.dataworkshop.dataworkshopus.service.UserSrv;

import javassist.NotFoundException;

/**
 * @author ramon
 *
 */
@RestController
public class UserCtrl implements IUserCtrl {

	@Autowired
	private UserSrv userSrv;

	@Override
	public ResponseEntity<User> saveUser(User user) {
		try {
			User _user = userSrv.saveUser(user);
			_user.setPassword("");
			return new ResponseEntity<User>(_user, HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * @Override public ResponseEntity<User> authenticateUser(User user) { try {
	 * User _user = userSrv.autheticate(user); _user.setPassword(""); return new
	 * ResponseEntity<User>(_user, HttpStatus.OK); } catch (NotFoundException e) {
	 * return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED); } catch
	 * (Exception e) { return new ResponseEntity<>(null,
	 * HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
}
