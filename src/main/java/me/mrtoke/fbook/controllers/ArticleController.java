package me.mrtoke.fbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@GetMapping
	public String getAllArticles(Model model) {
		return "/article/index";
	}
	
	@GetMapping("/new")
	public String newArticle(Model model) {
		return "/article/new";
	}
}
