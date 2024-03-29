package com.bridgelabz.usermngmt.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "USER_MNGMT")
public class User implements Serializable {
	private static final long serialVersionUID = 23545463822731L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String profilePic;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String gender;
	private String country;
	private String phone;
	private String extension;
	private String email;
	private String address;
	private String username;
	private String password;
	private boolean userRole;
	private boolean status;
	private LocalDate regDate;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<LoginHistory> loginHistory;

}
