/**
 * 
 */
package com.dataworkshop.dataworkshop.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ramon
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private long id;
	private String name;
	private String password;
	private String email;
	private String country;
	private LocalDateTime dateRegistry;
	private boolean enabled;
	private Set<RoleDTO> roles = new HashSet<>();

}
