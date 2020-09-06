/**
 * 
 */
package com.dataworkshop.dataworkshopbe.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;
import com.dataworkshop.dataworkshopbe.entity.Project;
import com.dataworkshop.dataworkshopbe.enums.DtoStatus;
import com.dataworkshop.dataworkshopbe.mapper.ProjectMapper;
import com.dataworkshop.dataworkshopbe.repository.ProjectRepository;

/**
 * @author ramon
 *
 */
@Service
public class ProjectSrv implements IProjectSrv {

	@Autowired
	ProjectRepository repository;

	@Override
	public ProjectDto findProyectByName(String name) {
		ProjectDto res = null;
		Project entity = new Project();

		entity = repository.findByName(name).get();
		res = ProjectMapper.mapProjectToDto(entity);

		return res;
	}

	@Override
	public List<ProjectDto> findAllProjects() throws Exception {
		List<ProjectDto> res = new ArrayList<ProjectDto>();

		List<Project> entityList;
		entityList = repository.findAll();
		res = entityList.stream().map(en -> ProjectMapper.mapProjectToDto(en)).collect(Collectors.toList());

		return res;
	}

	@Override
	public List<ProjectDto> findAllProjects(String name) throws Exception {
		List<ProjectDto> res = new ArrayList<ProjectDto>();

		List<Project> entityList;
		entityList = repository.findByNameContainsIgnoreCase(name).get();
		res = entityList.stream().map(en -> ProjectMapper.mapProjectToDto(en)).collect(Collectors.toList());

		return res;
	}

	@Override
	public List<ProjectDto> findAllProjectsFavourites() throws Exception {
		List<ProjectDto> res = new ArrayList<ProjectDto>();

		List<Project> entityList;
		entityList = repository.findAllFavourites().get();
		res = entityList.stream().map(en -> ProjectMapper.mapProjectToDto(en)).collect(Collectors.toList());

		return res;
	}

	@Override
	public ProjectDto saveProyect(ProjectDto project) throws Exception {
		ProjectDto res = new ProjectDto();
		Project entity = ProjectMapper.mapProjectToEntity(project);

		entity.setDateRegistry(LocalDateTime.now());
		entity.setStatus(DtoStatus.STATUS_ACTIVE);
		res = ProjectMapper.mapProjectToDto(repository.save(entity));

		return res;
	}

	@Override
	public void deleteProyect(long id) throws Exception {
		repository.deleteById(id);
	}

}
