package com.springproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.springproject.course.entities.User;
import com.springproject.course.repositories.UserRepository;
import com.springproject.course.service.exception.DBException;
import com.springproject.course.service.exception.NotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service //Coponent ou Repository(depende do que vc quiser)
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public List<User> findAll(){
		return ur.findAll();
	}
	
	public User findById(Long id){
			Optional<User> obj = ur.findById(id);
			return obj.orElseThrow(() -> new NotFoundException(id));
	}
	public User insert(User obj) {
		return ur.save(obj);
	}
	public void delete(Long id) {
		try {
			ur.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new NotFoundException(id);
		}catch(RuntimeException e) {
			throw new DBException(e.getMessage());
		}
	}
	public User update(Long id,User obj) {
		try {
			User entity = ur.getReferenceById(id);
			updateData(entity,obj);
			return ur.save(entity);
		}catch(EntityNotFoundException e) {
			throw new NotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
