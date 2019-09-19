package com.bridgelabz.usermngmt.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginDto {

	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}
