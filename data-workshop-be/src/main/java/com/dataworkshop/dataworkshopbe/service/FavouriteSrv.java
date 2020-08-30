/**
 * 
 */
package com.dataworkshop.dataworkshopbe.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshopbe.dto.FavouriteDto;
import com.dataworkshop.dataworkshopbe.entity.Favourite;
import com.dataworkshop.dataworkshopbe.enums.DtoStatus;
import com.dataworkshop.dataworkshopbe.repository.FavouriteRepository;
import com.dataworkshop.dataworkshopbe.repository.ProjectRepository;

/**
 * @author ramon
 *
 */
@Service
public class FavouriteSrv implements IFavouriteSrv {
	
	@Autowired
	FavouriteRepository repository;
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public FavouriteDto saveFavourite(FavouriteDto favourite) {
		try {
			Favourite favouriteEntity = new Favourite();
			
			favouriteEntity.setIdUser(0);
			favouriteEntity.setProject(projectRepository.findById(favourite.getIdProject()).get());
			favouriteEntity.setDateRegistry(LocalDateTime.now());
			favouriteEntity.setStatus(DtoStatus.STATUS_ACTIVE);
			
			repository.save(favouriteEntity);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public void deleteFavourite(long id) throws Exception {
		repository.deleteById(id);
	}

}
