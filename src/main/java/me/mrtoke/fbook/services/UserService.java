package me.mrtoke.fbook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.mrtoke.fbook.dao.IUserRepository;
import me.mrtoke.fbook.entities.User;

@Service
public class UserService {
	@Autowired
	IUserRepository userRepo;
	
	public List<User> findAll(){
		List<User> users = userRepo.findAll();
		return users;
	}
	
	public Optional<User> findById(long id) {
		return userRepo.findById(id);
	}
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public void deleteById(long id) {
		userRepo.deleteById(id);
	}
}
