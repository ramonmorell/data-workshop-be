/**
 * 
 */
package com.dataworkshop.dataworkshopbe.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "TBL_FAVOURITES")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Favourite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private long idUser;
	@ManyToOne
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;
	@NotNull
	private LocalDateTime dateRegistry;
	@NotNull
	private DtoStatus status;

	public Favourite(long id, @NotNull long idUser, Project project, @NotNull LocalDateTime dateRegistry,
			@NotNull DtoStatus status) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.project = project;
		this.dateRegistry = dateRegistry;
		this.status = status;
	}
}
