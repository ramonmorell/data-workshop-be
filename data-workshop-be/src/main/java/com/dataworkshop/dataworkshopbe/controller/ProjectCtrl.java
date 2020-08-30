/**
 * 
 */
package com.dataworkshop.dataworkshopbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;
import com.dataworkshop.dataworkshopbe.service.ProjectSrv;

/**
 * @author ramon
 *
 */
@RestController
public class ProjectCtrl implements IProjectCtrl {
	
	@Autowired
	ProjectSrv projectSrv;
	

	@Override
	public ProjectDto findProyectByName(String name) {
		// TODO Auto-generated method stub
		return projectSrv.findProyectByName(name);
	}

	@Override
	public List<ProjectDto> findAllProjects(String name) {
		// TODO Auto-generated method stub
		if(name != null) {
			return projectSrv.findAllProjects(name);
		} else {
			return projectSrv.findAllProjects();
		}
		
	}


	@Override
	public ResponseEntity<ProjectDto> saveProyect(ProjectDto project) {
		// TODO Auto-generated method stub
		try {
			ProjectDto _project = projectSrv.saveProyect(project);
			return new ResponseEntity<>(_project, HttpStatus.CREATED);
		} catch ( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<HttpStatus> deleteProject(long id) {
		// TODO Auto-generated method stub
		try {
			projectSrv.deleteProyect(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
