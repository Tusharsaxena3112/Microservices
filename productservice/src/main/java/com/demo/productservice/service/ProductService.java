package com.demo.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.productservice.model.Product;
import com.demo.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@SuppressWarnings("unused")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> findProductById(Long id){
		return productRepository.findById(id);
	}
	
	public Product updateProduct(Product product) {
		Product existProduct = productRepository.findById(product.getId()).get();
		if(existProduct!=null) {
			existProduct.setName(product.getName());
			existProduct.setPrice(product.getPrice());
			existProduct.setDescription(product.getDescription());
			return productRepository.save(existProduct);
		}
		
		return null;
		
	}
	
	public boolean deleteProduct(Long id){
		Product existProduct = productRepository.findById(id).get();
		if(existProduct!=null) {
			productRepository.delete(existProduct);
			return true;
		}
		return false;
	}

}
