package com.springproject.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.course.entities.User;
import com.springproject.course.service.UserService;

@RestController //EXPO
@RequestMapping(value="/users") //EXPO
public class UserResource {
	@Autowired
	private UserService server;
	
	@GetMapping//EXPO
	public ResponseEntity<List<User>> findAll(){
		List<User> list = server.findAll();
		return ResponseEntity.ok().body(list); //EXPO
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = server.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	
}
