package com.ravi.student.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.student.AddressFeignClient;
import com.ravi.student.model.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {

	Logger logger = LoggerFactory.getLogger(CommonService.class);
	long count = 1;
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	@CircuitBreaker(name = "addressService", fallbackMethod = "fallBackGetAddressById")
	public AddressResponse getAddressById(Long id) {
		logger.info("count = "+count);
		count++;
		AddressResponse addressResponse = addressFeignClient.getAddress(id);
		return addressResponse;
	}
	
	public AddressResponse fallBackGetAddressById(Long id, Throwable th) {
		logger.error("Error = "+th);
		return new AddressResponse();
	}
}
