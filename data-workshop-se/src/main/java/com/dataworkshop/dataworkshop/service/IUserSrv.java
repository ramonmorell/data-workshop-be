/**
 * 
 */
package com.dataworkshop.dataworkshop.service;

import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshop.entity.User;

/**
 * @author ramon
 *
 */
@Service
public interface IUserSrv {
	
	public User finsUserByname(String name) throws Exception; 
	
	public User saveUser(User user) throws Exception; 
	
	/* public User autheticate(User user) throws Exception; */

}
