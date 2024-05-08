package com.ravi.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.ravi.mvc.model.Product;
import com.ravi.mvc.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/getform")
	public String getProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product",product);
		return "product";
	}
	
	@PostMapping("/saveproduct")
	public String sumbitProduct(@ModelAttribute Product product) {
		boolean status = productService.createProduct(product);
		if(status)
			return "redirect:/products/getproducts";
		else
			return "fail";
	}
	
	@GetMapping("/getproducts")
	public String getAllProducts(@ModelAttribute Product product,Model model) {
		List<Product> products = productService.showAllProducts();
		model.addAttribute("products",products);
		return "product-list";
	}
	
	@GetMapping("/delete/{proId}")
	public String deleteProduct(@PathVariable Long proId) {
		productService.deleteProductById(proId);
		return "redirect:/products/getproducts";
	}
	
	@GetMapping("/edit/{proId}")
	public String editProduct(@PathVariable Long proId,Model model) {
		Optional<Product> product = productService.updateProductById(proId);
		model.addAttribute("product",product);
		return "updated-product";
	}
}
