/**
 * 
 */
package com.dataworkshop.dataworkshopbe.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;

/**
 * @author ramon
 *
 */
@RestController
@RequestMapping("/api")
public interface IProjectCtrl {
	
	@GetMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProjectDto findProyectByName(@RequestParam String name);

	@GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProjectDto> findAllProjects();
	
	@PostMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProjectDto saveProyect();

}
