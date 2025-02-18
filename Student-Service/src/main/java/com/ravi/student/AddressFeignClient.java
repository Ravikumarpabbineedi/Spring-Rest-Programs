package com.ravi.student;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ravi.student.model.AddressResponse;

@FeignClient(value ="Address-Service", path = "/api/address", name = "Address-Service")
public interface AddressFeignClient {

	@GetMapping("/getbyid/{id}")
	public AddressResponse getAddress(@PathVariable Long id);
}
