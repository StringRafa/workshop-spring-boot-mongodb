package com.panambystudio.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.panambystudio.workshopmongo.dto.AuthorDTO;
import com.panambystudio.workshopmongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(maria, pedro, antonio));
		
		Post post1 = new Post(null, sdf.parse("04/05/2022"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("03/05/2022"), "Bom dia!", "Um ótimo dia para todos nos...", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("04/05/2022"), new AuthorDTO(pedro));
		
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("04/05/2022"), new AuthorDTO(antonio));
		
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("04/05/2022"), new AuthorDTO(antonio));
		
		post1.setComments(Arrays.asList(c1, c2));
		//post1.getComments().addAll(Arrays.asList(c1, c2));
		
		post2.setComments(Arrays.asList(c3));
		//post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
	}

}
