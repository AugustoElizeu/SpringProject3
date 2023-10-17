package com.springproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.course.entities.Category;
import com.springproject.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cr;
	
	public List<Category> findAll(){
		return cr.findAll();
	}
	
	public Category findById(Long id){
		Optional<Category> obj = cr.findById(id);
		return obj.get();
	}
	

}
