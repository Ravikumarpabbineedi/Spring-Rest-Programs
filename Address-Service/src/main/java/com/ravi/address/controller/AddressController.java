package com.ravi.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.address.entity.Address;
import com.ravi.address.model.AddressDetails;
import com.ravi.address.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/save")
	public Address createAddress(@RequestBody AddressDetails addressDetails) {
		return addressService.saveAddress(addressDetails);
	}
	
	@GetMapping("/getbyid/{id}")
	public Address getAddress(@PathVariable long id) {
		return addressService.getAddressById(id);
	}
}
