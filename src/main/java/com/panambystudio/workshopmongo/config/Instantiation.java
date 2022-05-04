package com.panambystudio.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.panambystudio.workshopmongo.entities.Post;
import com.panambystudio.workshopmongo.entities.User;
import com.panambystudio.workshopmongo.repositories.PostRepository;
import com.panambystudio.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Barbosa", "mariab@gmail.com");
		User pedro = new User(null, "Pedro Souza", "pedros@gmail.com");
		User antonio = new User(null, "Antônio Silva", "antonios@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("04/05/2022"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("03/05/2022"), "De rolê", "De rolê na quebrada", pedro);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		userRepository.saveAll(Arrays.asList(maria, pedro, antonio));
	}

}
