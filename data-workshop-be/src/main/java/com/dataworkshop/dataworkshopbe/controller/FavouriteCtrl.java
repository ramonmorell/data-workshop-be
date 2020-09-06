/**
 * 
 */
package com.dataworkshop.dataworkshopbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshopbe.dto.FavouriteDto;
import com.dataworkshop.dataworkshopbe.service.FavouriteSrv;

/**
 * @author ramon
 *
 */
@RestController
public class FavouriteCtrl implements IFavouriteCtrl {

	@Autowired
	FavouriteSrv favouriteSrv;

	@Override
	public ResponseEntity<FavouriteDto> saveFavourite(FavouriteDto favourite) {
		try {
			FavouriteDto _favourite = favouriteSrv.saveFavourite(favourite);
			return new ResponseEntity<FavouriteDto>(_favourite, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteProject(long id) {
		try {
			favouriteSrv.deleteFavourite(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
