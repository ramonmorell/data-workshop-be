/**
 * 
 */
package com.dataworkshop.dataworkshopbe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;

/**
 * @author ramon
 *
 */
@Service
public interface IProjectSrv {
	public ProjectDto findProyectByName(String name) throws Exception;

	public List<ProjectDto> findAllProjects() throws Exception;

	public List<ProjectDto> findAllProjects(String name) throws Exception;

	public List<ProjectDto> findAllProjectsFavourites() throws Exception;

	public ProjectDto saveProyect(ProjectDto project) throws Exception;

	public void deleteProyect(long id) throws Exception;
}
