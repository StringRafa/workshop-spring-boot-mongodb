package com.panambystudio.workshopmongo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panambystudio.workshopmongo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User alex = new User("2", "Alex Barbosa", "alex@gmail.com");
		User pedro = new User("3", "Pedro Souza", "pedro@gmail.com");
		List<User> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(maria, alex, pedro));
		
		return ResponseEntity.ok().body(list);
	}
}
