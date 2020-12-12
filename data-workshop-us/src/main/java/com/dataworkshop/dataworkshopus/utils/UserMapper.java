/**
 * 
 */
package com.dataworkshop.dataworkshopus.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dataworkshop.dataworkshopus.dto.RoleDTO;
import com.dataworkshop.dataworkshopus.dto.UserDTO;
import com.dataworkshop.dataworkshopus.entity.Role;
import com.dataworkshop.dataworkshopus.entity.User;

/**
 * @author ramon
 *
 */
@Component
public class UserMapper {
	public Set<RoleDTO> mapRoles (Set<Role> roles) {
		Set<RoleDTO> _rolesDTO = new HashSet<RoleDTO>(); 
		roles.stream().map(role -> new RoleDTO(role.getId(), role.getName())).collect(Collectors.toSet());
		return _rolesDTO;
	}
	
	public UserDTO mapUserToUserDTO(User user) {
		UserDTO _userDTO = new UserDTO();
		_userDTO.setId(user.getId());
		_userDTO.setName(user.getName());
		_userDTO.setPassword(user.getPassword());
		_userDTO.setEmail(user.getEmail());
		_userDTO.setCountry(user.getCountry());
		_userDTO.setEnabled(user.isEnabled());
		_userDTO.setRoles(mapRoles(user.getRoles()));
		return _userDTO;
	}
	
	public User mapUserDTOToUser(UserDTO userDTO) {
		User _user = new User();
		_user.setId(userDTO.getId());
		_user.setName(userDTO.getName());
		_user.setPassword(userDTO.getPassword());
		_user.setEmail(userDTO.getEmail());
		_user.setCountry(userDTO.getCountry());
		_user.setDateRegistry(userDTO.getDateRegistry());
		_user.setEnabled(userDTO.isEnabled());
		return _user;
	}
}
