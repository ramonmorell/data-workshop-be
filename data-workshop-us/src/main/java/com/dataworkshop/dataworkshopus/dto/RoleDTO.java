package com.dataworkshop.dataworkshopus.dto;

import com.dataworkshop.dataworkshopus.enums.RoleNames;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
	private long id;
	private RoleNames name;
}
