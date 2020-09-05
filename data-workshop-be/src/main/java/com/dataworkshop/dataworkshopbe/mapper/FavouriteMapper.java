/**
 * 
 */
package com.dataworkshop.dataworkshopbe.mapper;

import com.dataworkshop.dataworkshopbe.dto.FavouriteDto;
import com.dataworkshop.dataworkshopbe.entity.Favourite;

/**
 * @author ramon
 *
 */
public class FavouriteMapper {
	public static FavouriteDto mapFavourite(Favourite entity) {
		FavouriteDto res = new FavouriteDto();

		res.setId(entity.getId());
		res.setIdUser(entity.getIdUser());
		res.setIdProject(entity.getProject().getId());
		res.setDateRegistry(entity.getDateRegistry());
		res.setStatus(entity.getStatus());

		return res;
	}
}
