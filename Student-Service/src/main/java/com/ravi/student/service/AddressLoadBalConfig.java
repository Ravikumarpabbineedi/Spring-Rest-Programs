package com.ravi.student.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value = "Address-Service")
public class AddressLoadBalConfig {

	@LoadBalanced
	@Bean
	public Feign.Builder feignBuilder() {
		
		return Feign.builder();
	}
}
