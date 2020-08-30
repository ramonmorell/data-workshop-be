/**
 * 
 */
package com.dataworkshop.dataworkshopbe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataworkshop.dataworkshopbe.entity.ProjectEntity;

/**
 * @author ramon
 *
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>{
	Optional <ProjectEntity> findByName(String name);
	Optional <ProjectEntity> findById(Long id);
	Optional <List<ProjectEntity>> findByNameContainsIgnoreCase(String name);
}
