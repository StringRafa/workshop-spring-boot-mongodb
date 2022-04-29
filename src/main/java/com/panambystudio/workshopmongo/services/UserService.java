package com.panambystudio.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panambystudio.workshopmongo.entities.User;
import com.panambystudio.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Transactional
	public User insert(User obj) {
		obj.setId(null);
		obj = userRepository.save(obj);
		return obj;
	}
}
