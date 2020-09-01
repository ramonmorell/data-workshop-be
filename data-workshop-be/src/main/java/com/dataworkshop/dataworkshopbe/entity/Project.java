/**
 * 
 */
package com.dataworkshop.dataworkshopbe.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="TBL_PROJECTS")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Project implements Serializable {

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
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Favourite> favourites;
	@NotNull
	private LocalDateTime dateRegistry;
	@NotNull
	private DtoStatus status;
	
	public Project(long id, @NotNull String name, @NotNull String description, long idData,
			Set<Favourite> favourites, @NotNull LocalDateTime dateRegistry, @NotNull DtoStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.idData = idData;
		this.favourites = favourites;
		this.dateRegistry = dateRegistry;
		this.status = status;
	}

}
