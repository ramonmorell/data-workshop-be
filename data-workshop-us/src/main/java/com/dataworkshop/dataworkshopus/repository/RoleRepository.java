/**
 * 
 */
package com.dataworkshop.dataworkshopus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataworkshop.dataworkshopus.entity.Role;
import com.dataworkshop.dataworkshopus.enums.RoleNames;

/**
 * @author ramon
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleNames roleName);
}
