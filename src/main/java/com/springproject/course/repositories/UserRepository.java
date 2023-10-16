package com.springproject.course.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.course.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	

}
