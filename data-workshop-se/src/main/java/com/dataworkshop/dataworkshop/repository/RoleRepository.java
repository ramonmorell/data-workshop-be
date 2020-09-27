/**
 * 
 */
package com.dataworkshop.dataworkshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataworkshop.dataworkshop.entity.Role;
import com.dataworkshop.dataworkshop.enums.RoleNames;

/**
 * @author ramon
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleNames roleName);
}
