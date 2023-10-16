package com.springproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.course.entities.User;
import com.springproject.course.repositories.UserRepository;

@Service //Coponent ou Repository(depende do que vc quiser)
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public List<User> findAll(){
		return ur.findAll();
	}
	
	public User findById(long id){
		Optional<User> obj = ur.findById(id);
		return obj.get();
		
	}
}
