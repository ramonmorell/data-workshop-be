/**
 * 
 */
package com.dataworkshop.dataworkshopbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataworkshop.dataworkshopbe.entity.Favourite;

/**
 * @author ramon
 *
 */
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

}
