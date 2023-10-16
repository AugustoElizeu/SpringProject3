package com.springproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.course.entities.Order;
import com.springproject.course.repositories.OrderRepository;

@Service //Coponent ou Repository(depende do que vc quiser)
public class OrderService {

	@Autowired
	private OrderRepository ur;
	
	public List<Order> findAll(){
		return ur.findAll();
	}
	
	public Order findById(long id){
		Optional<Order> obj = ur.findById(id);
		return obj.get();
		
	}
}
