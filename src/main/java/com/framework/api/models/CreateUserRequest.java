package com.framework.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

	private String name;
	private String email;
	private String password;
	private String title;

	private String birth_date;
	private String birth_month;
	private String birth_year;

	private String firstname;
	private String lastname;

	private String company;

	private String address1;
	private String address2;

	private String country;
	private String zipcode;
	private String state;
	private String city;

	private String mobile_number;

}