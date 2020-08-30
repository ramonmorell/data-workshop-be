/**
 * 
 */
package com.dataworkshop.dataworkshopbe.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;
import com.dataworkshop.dataworkshopbe.entity.ProjectEntity;
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

	static ProjectDto mapperProject(ProjectEntity entity) {
		ProjectDto res = new ProjectDto();
		res.setId(entity.getId());
		res.setName(entity.getName());
		res.setDescription(entity.getDescription());
		res.setIdData(entity.getIdData());
		res.setDateRegistry(entity.getDateRegistry());
		res.setStatus(entity.getStatus());

		return res;
	}

	@Override
	public ProjectDto findProyectByName(String name) {
		ProjectDto res = null;
		ProjectEntity entity = new ProjectEntity();
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
		List<ProjectDto> res = null;

		try {
			List<ProjectEntity> entityList;
			entityList = repository.findAll();
			res = entityList.stream().map(en -> mapperProject(en)).collect(Collectors.toList());

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}

	@Override
	public ProjectDto saveProyect(ProjectDto project) throws Exception {
		ProjectDto res = new ProjectDto();
		ProjectEntity entity = new ProjectEntity();

		entity.setName(project.getName());
		entity.setDescription(project.getDescription());
		entity.setIdData(project.getIdData());
		entity.setDateRegistry(LocalDateTime.now());
		entity.setStatus(DtoStatus.STATUS_ACTIVE);

		res = mapperProject(repository.save(entity));
		return res;
	}
	
	@Override
	public void deleteProyect(long id) throws Exception {
		repository.deleteById(id);
	}
}
