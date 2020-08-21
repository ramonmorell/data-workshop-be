/**
 * 
 */
package com.dataworkshop.dataworkshopbe.repository;

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
	Optional <ProjectEntity> findByName(String nombre);
	Optional <ProjectEntity> findById(Long id);
}
