package com.ravi.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.mvc.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
