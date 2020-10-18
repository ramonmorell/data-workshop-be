/**
 * 
 */
package com.dataworkshop.dataworkshopus.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.dataworkshop.dataworkshopus.enums.RoleNames;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ramon
 *
 */
@Entity
@Table(name = "TBL_ROLES")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3641500099020831117L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(unique = true)
	@Enumerated(EnumType.STRING)
	private RoleNames name;

	/**
	 * @param nombre
	 */
	public Role(@NotNull RoleNames name) {
		super();
		this.name = name;
	}
	
}
