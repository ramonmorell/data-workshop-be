/**
 * 
 */
package com.dataworkshop.dataworkshopbe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dataworkshop.dataworkshopbe.entity.Project;

/**
 * @author ramon
 *
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	Optional <Project> findByName(String name);
	Optional <Project> findById(Long id);
	Optional <List<Project>> findByNameContainsIgnoreCase(String name);
	@Query("SELECT a FROM Project a WHERE a.id IN(SELECT a.project FROM Favourite a)")
	Optional <List<Project>> findAllFavourites();
}
