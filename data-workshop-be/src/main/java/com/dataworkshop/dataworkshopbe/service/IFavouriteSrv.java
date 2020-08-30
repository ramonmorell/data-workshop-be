/**
 * 
 */
package com.dataworkshop.dataworkshopbe.service;

import org.springframework.stereotype.Service;

import com.dataworkshop.dataworkshopbe.dto.FavouriteDto;

/**
 * @author ramon
 *
 */
@Service
public interface IFavouriteSrv {

	public FavouriteDto saveFavourite (FavouriteDto favourite);
	
	public void deleteFavourite (long id) throws Exception;
}
