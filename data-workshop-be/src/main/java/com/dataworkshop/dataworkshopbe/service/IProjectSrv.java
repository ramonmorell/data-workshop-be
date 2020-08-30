/**
 * 
 */
package com.dataworkshop.dataworkshopbe.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;

/**
 * @author ramon
 *
 */
@Service
public interface IProjectSrv {
	public ProjectDto findProyectByName(@RequestParam String name);

	public List<ProjectDto> findAllProjects();

	public ProjectDto saveProyect (ProjectDto project) throws Exception;

	public void deleteProyect (long id) throws Exception;
}
