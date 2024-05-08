package com.ravi.rest.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String location;
	private double rating;
	private String email;
	private String mobile;
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@LastModifiedBy
	private String updatedBy;
	
	@LastModifiedDate
	private LocalDateTime upatedAt;
}
