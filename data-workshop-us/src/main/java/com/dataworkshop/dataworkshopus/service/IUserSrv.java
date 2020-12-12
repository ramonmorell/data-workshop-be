/**
 * 
 */
package com.dataworkshop.dataworkshopus.service;

import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshopus.entity.User;

/**
 * @author ramon
 *
 */
@Service
public interface IUserSrv {
	
	public User finsUserByname(String name) throws Exception; 
	
	public User saveUser(User user) throws Exception; 
	
}
