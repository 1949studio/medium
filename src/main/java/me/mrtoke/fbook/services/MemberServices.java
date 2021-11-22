package me.mrtoke.fbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.mrtoke.fbook.dao.IMemberRepository;
import me.mrtoke.fbook.entities.Member;

@Service
public class MemberServices {
	@Autowired
	IMemberRepository memberRepo;
	@Autowired
	PasswordEncoder passEncoder;
	
	public List<Member> findAll(){
		List<Member> users = memberRepo.findAll();
		return users;
	}
	
	public Page<Member> findSome(Pageable pageAndSize){
		return memberRepo.findAll(pageAndSize);
	}
	
	public Member findById(long id) {
		return memberRepo.findById(id).get();
	}
	
	public Member findByEmail(String email) {
		return memberRepo.findMemberByEmail(email);
	}
	
	public Member save(Member user) {
		String encodedPassword = passEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		String role = "ROLE_" + user.getClass().getSimpleName().toUpperCase();
		user.setRole(role);
		return memberRepo.save(user);
	}
	
	public void deleteById(long id) {
		memberRepo.deleteById(id);
	}
	
}
