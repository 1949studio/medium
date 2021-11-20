package me.mrtoke.fbook.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.mrtoke.fbook.entities.Post;
import me.mrtoke.fbook.entities.User;
import me.mrtoke.fbook.services.PostService;
import me.mrtoke.fbook.services.UserService;

@Controller
@RequestMapping("/posts")
public class PostController {
	//Field Dependency Injection
	@Autowired
	PostService postService;
//	IPostRepository postRepo;
	
	@Autowired
	UserService userService;
//	IUserRepository userRepo;
	
	// Constructor Dependency Injection
	// IPostRepository postRepo;
	// public PostController(IPostRepository postRepo){
	// this.postRepo = postRepo;
	// }
	
	// Setter Dependency Injection
	// IPostRepository postRepo;
	// @Autowired
	// public void setPostRepo(IPostRepository postRepo){
	// this.postRepo = postRepo;
	// }
	
	@GetMapping
	public String postWall(Model model) {
		List<Post> posts = postService.findAll();
		model.addAttribute("posts", posts);
		return "/post/index";
	}
	
	@GetMapping("/new")
	public String newPostForm(Model model) {
		Post newPost = new Post();
		
		model.addAttribute("newPost", newPost);
		return "/post/new";
	}
	
	@PostMapping("/save")
	public String savePost(Post newPost, Model model) {
		List<User> users = userService.findAll();
		newPost.setUser(users.get(0));
		newPost.setCreatedTime(new Date(System.currentTimeMillis()));
		postService.save(newPost);
		return "redirect:/posts";
	}
	
	@GetMapping("/user")
	public String findByUser(@RequestParam String id, Model model) {
		
		Optional<Post> posts = postService.findById(Long.parseLong(id));
		model.addAttribute("posts", posts);
		return "/post/index";
	}
}
