package me.mrtoke.fbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping
	public String homePage() {
		return "/home/index";
	}
	
	@GetMapping("login")
	public String login() {
		return "/home/login";
	}
	
	@GetMapping("/403")
	public String forbidden() {
		return "/home/forbidden";
	}
}
