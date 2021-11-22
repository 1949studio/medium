package me.mrtoke.fbook.api;

import javax.validation.Valid;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.mrtoke.fbook.entities.Member;
import me.mrtoke.fbook.services.MemberServices;

@RestController
@RequestMapping("/api2/members")
public class MembersApiController {
	
	@Autowired
	MemberServices memberService;
	
	@GetMapping
	public Iterable<Member> getMembers(){
		return memberService.findAll();
	}
	
	
	@GetMapping(params= {"page", "size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Member> findPaginatedMembers(@RequestParam("page") int page, 
			@RequestParam("size") int size){
		Pageable pageAndSize = PageRequest.of(page, size);
		return memberService.findSome(pageAndSize);
	}
	
	@GetMapping("/{id}")
	public Member getMemberById(@PathVariable("id") Long id) {
		return memberService.findById(id);
		
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Member create(@RequestBody @Valid Member member) {
		return memberService.save(member);
	}
	
	@PutMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public Member update(@RequestBody @Valid Member member) {
		return memberService.save(member);
	}
	
	@PatchMapping(path="/{id}", consumes="application/json")
	public Member partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Member member2Update) {
		Member member = memberService.findById(id);
		
		if(member2Update.getEmail() != null) {
			member.setEmail(member2Update.getEmail());
		}
		
		if(member2Update.getPassword() != null) {
			member.setPassword(member2Update.getPassword());
		}
		
		if(member2Update.getUsername() != null) {
			member.setUsername(member2Update.getUsername());
		}
		
		return memberService.save(member);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			memberService.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
