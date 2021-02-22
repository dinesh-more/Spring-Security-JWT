package com.averta.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.averta.api.entity.User;
import com.averta.api.repository.UserRepository;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {

		List<User> users = new ArrayList<>();
		users.add(new User(101, "admin", "password", "admin@gmail.com"));
		users.add(new User(102, "user1", "pwd1", "user1@gmail.com"));
		users.add(new User(103, "user2", "pwd2", "user2@gmail.com"));
		users.add(new User(104, "user3", "pwd3", "user3@gmail.com"));

		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
