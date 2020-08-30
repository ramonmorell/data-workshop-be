/**
 * 
 */
package com.dataworkshop.dataworkshopbe.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.dataworkshop.dataworkshopbe.enums.DtoStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ramon
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long idUser;
	private long idProject;
	private LocalDateTime dateRegistry;
	private DtoStatus status;
}
