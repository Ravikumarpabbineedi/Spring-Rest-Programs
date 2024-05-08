package com.ravi.rest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.rest.dto.DTO;
import com.ravi.rest.entity.Hospital;
import com.ravi.rest.model.HospitalDetails;
import com.ravi.rest.repo.HospitalRepo;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepo hospitalRepo;

	public DTO saveHospitalDetails(HospitalDetails hospitalDetails) {
		
		Hospital hospital = new Hospital();
		
		hospital.setName(hospitalDetails.getName());
		hospital.setLocation(hospitalDetails.getLocation());
		hospital.setRating(hospitalDetails.getRating());
		hospital.setEmail(hospitalDetails.getEmail());
		hospital.setMobile(hospitalDetails.getMobile());
		hospital.setCreatedBy(System.getProperty("user.name"));
		hospital.setCreatedAt(LocalDateTime.now());
		hospital.setUpdatedBy(System.getProperty("user.name"));
		hospital.setUpatedAt(LocalDateTime.now());
		
		hospitalRepo.save(hospital);
		
		DTO dto = new DTO();
		
		dto.setName(hospital.getName());
		dto.setLocation(hospital.getLocation());
		dto.setRating(hospital.getRating());
		
		return dto;
	}

	public Optional<Hospital> getHospitalById(long id) {
		Optional<Hospital> optionalHospital = hospitalRepo.findById(id);
		if(optionalHospital.isPresent()) {
			return optionalHospital;
		}
		else {
			return optionalHospital;
		}
	}

	public List<Hospital> saveAllHospitalDetails(List<HospitalDetails> hospitalDetails) {
		
		List<Hospital> hospitals = new ArrayList<>();
		
		
		
		for(HospitalDetails details : hospitalDetails) {
			
			Hospital hospital = new Hospital();
			
			hospital.setName(details.getName());
			hospital.setLocation(details.getLocation());
			hospital.setRating(details.getRating());
			hospital.setEmail(details.getEmail());
			hospital.setMobile(details.getMobile());
			hospital.setCreatedBy(System.getProperty("user.name"));
			hospital.setCreatedAt(LocalDateTime.now());
			hospital.setUpdatedBy(System.getProperty("user.name"));
			hospital.setUpatedAt(LocalDateTime.now());
			
			hospitals.add(hospital);
		}
		
		return hospitalRepo.saveAll(hospitals);
	}

	public List<Hospital> findAllDetails() {
		return hospitalRepo.findAll();
	}

	public void deleteById(long id) {
		 hospitalRepo.deleteById(id);
	}

	public Hospital updateById(long id, HospitalDetails details) {
		
		Optional<Hospital> optionalHospital = hospitalRepo.findById(id);
		Hospital hospital = null;
		if(optionalHospital.isPresent()) {
		    hospital = optionalHospital.get();
			
			hospital.setName(details.getName());
			hospital.setLocation(details.getLocation());
			hospital.setRating(details.getRating());
			hospital.setEmail(details.getEmail());
			hospital.setMobile(details.getMobile());
			hospital.setUpdatedBy(System.getProperty("user.name"));
			hospital.setUpatedAt(LocalDateTime.now());
		
			 return hospitalRepo.save(hospital);
		}
		else {
			return hospitalRepo.save(hospital);
		}
	}
}
