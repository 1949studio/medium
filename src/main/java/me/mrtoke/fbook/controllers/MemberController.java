package me.mrtoke.fbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import me.mrtoke.fbook.entities.Member;
import me.mrtoke.fbook.services.MemberServices;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	
	@Autowired
	MemberServices userService;
	
	@GetMapping("/new")
	public String newUserForm(Model model) {
//		User newUser = new User();
		model.addAttribute("newUser", new Member());
		return "user/new";
	}
	
	@GetMapping(params= {"page", "size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Member> findPaginatedMembers(@RequestParam("page") int page, 
			@RequestParam("size") int size){
		Pageable pageAndSize = PageRequest.of(page, size);
		return userService.findSome(pageAndSize);
	}
	
	@PostMapping("/save")
	public String createUser(Member user, Model model) {
		userService.save(user);
		return "redirect:/users/new";
	}
	
	
}
