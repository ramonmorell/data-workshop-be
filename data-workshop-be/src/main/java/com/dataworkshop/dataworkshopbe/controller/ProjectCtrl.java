/**
 * 
 */
package com.dataworkshop.dataworkshopbe.controller;

import java.util.ArrayList;
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
	public ResponseEntity<ProjectDto> findProyectByName(String name) {
		ProjectDto _project;

		try {
			_project = projectSrv.findProyectByName(name);
			return new ResponseEntity<>(_project, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<ProjectDto>> findAllProjects(String name) {
		List<ProjectDto> _listProjects;

		try {
			if (name != null) {
				_listProjects = projectSrv.findAllProjects(name);
			} else {
				_listProjects = projectSrv.findAllProjects();
			}
			return new ResponseEntity<List<ProjectDto>>(_listProjects, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<List<ProjectDto>>(new ArrayList<ProjectDto>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<List<ProjectDto>> findAllProjectsFavourites() {
		List<ProjectDto> _listProjects;

		try {
			_listProjects = projectSrv.findAllProjectsFavourites();
			return new ResponseEntity<List<ProjectDto>>(_listProjects, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<List<ProjectDto>>(new ArrayList<ProjectDto>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ProjectDto> saveProyect(ProjectDto project) {
		try {
			ProjectDto _project = projectSrv.saveProyect(project);
			return new ResponseEntity<ProjectDto>(_project, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteProject(long id) {
		try {
			projectSrv.deleteProyect(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
