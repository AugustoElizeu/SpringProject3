package com.springproject.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.course.entities.Product;
import com.springproject.course.service.ProductService;

@RestController //EXPO
@RequestMapping(value="/Products") //EXPO
public class ProductResource {
	@Autowired
	private ProductService server;
	
	@GetMapping//EXPO
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = server.findAll();
		return ResponseEntity.ok().body(list); //EXPO
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = server.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
