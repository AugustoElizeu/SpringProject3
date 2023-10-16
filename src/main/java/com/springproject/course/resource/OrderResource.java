package com.springproject.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.course.entities.Order;
import com.springproject.course.service.OrderService;

@RestController //EXPO
@RequestMapping(value="/orders") //EXPO
public class OrderResource {
	@Autowired
	private OrderService server;
	
	@GetMapping//EXPO
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = server.findAll();
		return ResponseEntity.ok().body(list); //EXPO
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = server.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	
}
