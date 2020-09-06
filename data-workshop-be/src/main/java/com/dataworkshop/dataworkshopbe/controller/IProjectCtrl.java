/**
 * 
 */
package com.dataworkshop.dataworkshopbe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;

/**
 * @author ramon
 *
 */
@RestController
public interface IProjectCtrl {

	@GetMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectDto> findProyectByName(@RequestParam String name);

	@GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProjectDto>> findAllProjects(@RequestParam(required = false) String name);

	@GetMapping(value = "/projectsFavourites", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProjectDto>> findAllProjectsFavourites();

	@PostMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectDto> saveProyect(@RequestBody(required = false) ProjectDto project);

	@DeleteMapping(value = "/project/{id}")
	public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id);

}
