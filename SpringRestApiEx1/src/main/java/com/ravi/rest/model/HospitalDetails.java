package com.ravi.rest.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDetails {
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Location is required")
	private String location;
	
	private double rating;
	
	@NotBlank(message = "Email is required")
	@Email
	private String email;
	
	@Pattern(regexp ="[0-9]{10}",message = "Mobile number must be 10 digits number")
	private String mobile;
	
}
