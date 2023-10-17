package com.springproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.course.entities.Product;
import com.springproject.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pr;
	
	public List<Product> findAll(){
		return pr.findAll();
	}
	
	public Product findById(Long id){
		Optional<Product> obj = pr.findById(id);
		return obj.get();
		
	}
}
