/**
 * 
 */
package com.dataworkshop.dataworkshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataworkshop.dataworkshop.entity.User;

/**
 * @author ramon
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByName(String name);

}
