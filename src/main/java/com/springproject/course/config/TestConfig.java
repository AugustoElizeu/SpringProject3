package com.springproject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springproject.course.entities.Order;
import com.springproject.course.entities.User;
import com.springproject.course.repositories.OrderRepository;
import com.springproject.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository ur;
	
	private OrderRepository ori;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1,"Maria","maria@gmail.com","9888888","1234456");
		User u2 = new User(2,"Pedro","Pedrokah@hotmail.com","988888","2343214");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		ur.saveAll(Arrays.asList(u1,u2));
		ori.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
