/**
 * 
 */
package com.dataworkshop.dataworkshopbe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataworkshop.dataworkshopbe.dto.FavouriteDto;

/**
 * @author ramon
 *
 */
@RestController
public interface IFavouriteCtrl {

	@PostMapping(value = "/favourite", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FavouriteDto> saveFavourite(@RequestBody(required = false) FavouriteDto favourite);

	@DeleteMapping(value = "/favourite/{id}")
	public ResponseEntity<HttpStatus> deleteFavourite(@PathVariable("id") long id);
}
