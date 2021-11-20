package me.mrtoke.fbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.mrtoke.fbook.entities.User;
import me.mrtoke.fbook.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/new")
	public String newUserForm(Model model) {
//		User newUser = new User();
		model.addAttribute("newUser", new User());
		return "user/new";
	}
	
	@PostMapping("/save")
	public String createUser(User user, Model model) {
		userService.save(user);
		return "redirect:/users/new";
	}
}
