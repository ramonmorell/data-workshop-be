/**
 * 
 */
package com.dataworkshop.dataworkshopus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataworkshop.dataworkshopus.entity.User;

/**
 * @author ramon
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByName(String name);

}
