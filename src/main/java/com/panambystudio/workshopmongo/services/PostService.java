package com.panambystudio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panambystudio.workshopmongo.entities.Post;
import com.panambystudio.workshopmongo.entities.User;
import com.panambystudio.workshopmongo.repositories.PostRepository;
import com.panambystudio.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> user = postRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}

	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
}
