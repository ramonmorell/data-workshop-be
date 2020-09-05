/**
 * 
 */
package com.dataworkshop.dataworkshopbe.mapper;

import java.util.HashSet;
import java.util.stream.Collectors;

import com.dataworkshop.dataworkshopbe.dto.ProjectDto;
import com.dataworkshop.dataworkshopbe.entity.Favourite;
import com.dataworkshop.dataworkshopbe.entity.Project;

/**
 * @author ramon
 *
 */
public class ProjectMapper {

	public static ProjectDto mapProjectToDto(Project entity) {
		ProjectDto res = new ProjectDto();

		res.setId(entity.getId());
		res.setName(entity.getName());
		res.setDescription(entity.getDescription());
		res.setIdData(entity.getIdData());
		res.setFavourites(entity.getFavourites().stream().map(en -> FavouriteMapper.mapFavourite(en))
				.collect(Collectors.toSet()));
		res.setDateRegistry(entity.getDateRegistry());
		res.setStatus(entity.getStatus());

		return res;
	}

	public static Project mapProjectToEntity(ProjectDto dto) {
		Project res = new Project();

		res.setId(dto.getId());
		res.setName(dto.getName());
		res.setDescription(dto.getDescription());
		res.setIdData(dto.getIdData());
		res.setFavourites(new HashSet<Favourite>());
		res.setDateRegistry(dto.getDateRegistry());
		res.setStatus(dto.getStatus());

		return res;
	}

}
