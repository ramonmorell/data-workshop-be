/**
 * 
 */
package com.dataworkshop.dataworkshopbe.dto;

import java.io.Serializable;
import java.util.Date;

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
public class ProjectDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String description;
	private long idData;
	private Date dateRegistry;
	private DtoStatus status;

}
