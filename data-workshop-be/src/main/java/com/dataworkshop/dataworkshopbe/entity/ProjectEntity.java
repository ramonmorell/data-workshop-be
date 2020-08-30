/**
 * 
 */
package com.dataworkshop.dataworkshopbe.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.dataworkshop.dataworkshopbe.enums.DtoStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ramon
 *
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProjectEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Column(unique = true)
	private String name;
	@NotNull
	private String description;
	// TODO
	private long idData;
	@NotNull
	private LocalDateTime dateRegistry;
	@NotNull
	private DtoStatus status;

	public ProjectEntity(@NotNull String name, @NotNull String description, long idData, @NotNull LocalDateTime dateRegistry,
			@NotNull DtoStatus status) {
		super();
		this.name = name;
		this.description = description;
		this.idData = idData;
		this.dateRegistry = dateRegistry;
		this.status = status;
	}

}
