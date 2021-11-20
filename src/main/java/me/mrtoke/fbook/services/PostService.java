package me.mrtoke.fbook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.mrtoke.fbook.dao.IPostRepository;
import me.mrtoke.fbook.entities.Post;

@Service
public class PostService {

	@Autowired
	private IPostRepository postRepo;
	
	public List<Post> findAll(){
		List<Post> allPosts = postRepo.findAll();
		
		return allPosts;
	}
	
	public Optional<Post> findById(Long id){
		return postRepo.findById(id);
	}
	
	public void save(Post post) {
		postRepo.save(post);
	}
	
	public void deleteById(Long id) {
		postRepo.deleteById(id);
	}
}
