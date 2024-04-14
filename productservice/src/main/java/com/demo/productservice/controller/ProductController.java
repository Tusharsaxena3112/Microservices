package com.demo.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.productservice.model.Product;
import com.demo.productservice.service.ProductService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value="products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<?> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		Product savedProduct = productService.addProduct(product);
		return ResponseEntity.ok(savedProduct);
	}
	
	
	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable Long productId){
		Optional<Product> product = productService.findProductById(productId);
		if(!product.isPresent()) {
			return ResponseEntity.status(400).body("Product not found");
		}
		return ResponseEntity.ok(product);
	}

	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@RequestBody Product product){
		Product updatedProduct = productService.updateProduct(product);
		if(updatedProduct==null) {
			return ResponseEntity.status(400).body("Product cannot be updated as it is not found");
		}
		return ResponseEntity.ok(updatedProduct);
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
		boolean isDeleted = productService.deleteProduct(productId);
		if(!isDeleted) {
			return ResponseEntity.status(400).body("Product cannot be deleted as it is not found");
		}
		return ResponseEntity.ok("Product deleted successfully!");
	}
}
