/**
 * 
 */
package com.dataworkshop.dataworkshopbe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;

/**
 * @author ramon
 *
 */
@RestController
public class ProjectCtrl implements IProjectCtrl {

	@Override
	public ProjectDto findProyectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectDto> findAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDto saveProyect() {
		// TODO Auto-generated method stub
		return null;
	}

}
