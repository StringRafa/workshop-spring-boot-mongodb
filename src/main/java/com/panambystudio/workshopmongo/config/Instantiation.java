package com.panambystudio.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.panambystudio.workshopmongo.entities.User;
import com.panambystudio.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Barbosa", "mariab@gmail.com");
		User pedro = new User(null, "Pedro Souza", "pedros@gmail.com");
		User antonio = new User(null, "Antônio Silva", "antonios@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, pedro, antonio));
	}

}
