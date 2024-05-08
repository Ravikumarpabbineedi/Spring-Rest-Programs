package com.ravi.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.rest.dto.DTO;
import com.ravi.rest.entity.Hospital;
import com.ravi.rest.model.HospitalDetails;
import com.ravi.rest.service.HospitalService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/ravi")
public class HospitalController {

	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/save")
	public DTO save(@Valid @RequestBody HospitalDetails hospitalDetails) {
		return hospitalService.saveHospitalDetails(hospitalDetails);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Hospital> getById(@PathVariable long id) {
		return hospitalService.getHospitalById(id);
	}
	
	@PostMapping("/saveall")
	public List<Hospital> saveAll(@Valid @RequestBody List<HospitalDetails> hospitalDetails){
		return hospitalService.saveAllHospitalDetails(hospitalDetails);
	}
	
	@GetMapping("/getall")
	public List<Hospital> getall(){
		return hospitalService.findAllDetails();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id){
		hospitalService.deleteById(id);
	}
	
	@PutMapping("/upd/{id}")
	public Hospital putMethodName(@PathVariable long id, @RequestBody HospitalDetails details) {
		
		return hospitalService.updateById(id,details);
	}
}