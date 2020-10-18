/**
 * 
 */
package com.dataworkshop.dataworkshopus.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ramon
 *
 */
@Entity
@Table(name = "TBL_USERS")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1701162171961410051L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Column(unique = true)
	private String name;
	@NotNull
	private String password;
	@NotNull
	@Column(unique = true)
	private String email;
	@NotNull
	private String country;
	@NotNull
	private LocalDateTime dateRegistry;
	@NotNull
	private boolean enabled;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TBL_USERS_ROLES", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param email
	 * @param country
	 * @param dateRegistry
	 * @param enabled
	 */
	public User(long id, @NotNull String name, @NotNull String password, @NotNull String email, @NotNull String country,
			@NotNull LocalDateTime dateRegistry, @NotNull boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
		this.dateRegistry = dateRegistry;
		this.enabled = enabled;
	}

}
