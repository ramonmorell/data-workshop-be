/**
 * 
 */
package com.dataworkshop.dataworkshopbe.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshopbe.dto.FavouriteDto;
import com.dataworkshop.dataworkshopbe.dto.ProjectDto;
import com.dataworkshop.dataworkshopbe.entity.Favourite;
import com.dataworkshop.dataworkshopbe.entity.Project;
import com.dataworkshop.dataworkshopbe.enums.DtoStatus;
import com.dataworkshop.dataworkshopbe.repository.ProjectRepository;

/**
 * @author ramon
 *
 */
@Service
public class ProjectSrv implements IProjectSrv {

	@Autowired
	ProjectRepository repository;

	static ProjectDto mapperProject(Project entity) {
		ProjectDto res = new ProjectDto();
		res.setId(entity.getId());
		res.setName(entity.getName());
		res.setDescription(entity.getDescription());
		res.setIdData(entity.getIdData());
		res.setFavourites(entity.getFavourites().stream().map(en -> mapperFavourites(en)).collect(Collectors.toSet()));
		res.setDateRegistry(entity.getDateRegistry());
		res.setStatus(entity.getStatus());

		return res;
	}

	static FavouriteDto mapperFavourites(Favourite entity) {
		FavouriteDto res = new FavouriteDto();
		res.setId(entity.getId());
		res.setIdUser(entity.getIdUser());
		res.setIdProject(entity.getProject().getId());
		res.setDateRegistry(entity.getDateRegistry());
		res.setStatus(entity.getStatus());


		return res;
	}

	@Override
	public ProjectDto findProyectByName(String name) {
		ProjectDto res = null;
		Project entity = new Project();
		try {
			entity = repository.findByName(name).get();
			res = mapperProject(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return res;
	}

	@Override
	public List<ProjectDto> findAllProjects() {
		List<ProjectDto> res = new ArrayList<ProjectDto>();

		try {
			List<Project> entityList;
			entityList = repository.findAll();
			res = entityList.stream().map(en -> mapperProject(en)).collect(Collectors.toList());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return res;
	}

	@Override
	public List<ProjectDto> findAllProjects(String name) {
		List<ProjectDto> res = new ArrayList<ProjectDto>();

		try {
			List<Project> entityList;
			entityList = repository.findByNameContainsIgnoreCase(name).get();
			res = entityList.stream().map(en -> mapperProject(en)).collect(Collectors.toList());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return res;
	}

	@Override
	public ProjectDto saveProyect(ProjectDto project) throws Exception {
		ProjectDto res = new ProjectDto();
		Project entity = new Project();

		entity.setName(project.getName());
		entity.setDescription(project.getDescription());
		entity.setIdData(project.getIdData());
		entity.setDateRegistry(LocalDateTime.now());
		entity.setStatus(DtoStatus.STATUS_ACTIVE);
		entity.setFavourites(new HashSet<Favourite>());
		
		res = mapperProject(repository.save(entity));
		
		return res;
	}

	@Override
	public void deleteProyect(long id) throws Exception {
		repository.deleteById(id);
	}

}
