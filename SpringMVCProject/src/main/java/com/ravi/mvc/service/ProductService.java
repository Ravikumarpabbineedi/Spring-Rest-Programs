package com.ravi.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.mvc.model.Product;
import com.ravi.mvc.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	public boolean createProduct(Product product) {
		Product result = productRepo.save(product);
		if(result != null)
			return true;
		else
			return false;
	}

	public List<Product> showAllProducts() {
		return productRepo.findAll();
	}

	public void deleteProductById(Long proId) {
		productRepo.deleteById(proId);
	}

	public Optional<Product> updateProductById(Long proId) {
		return productRepo.findById(proId);
	}
}
