package com.dataworkshop.dataworkshop.dto;

import com.dataworkshop.dataworkshop.enums.RoleNames;
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
