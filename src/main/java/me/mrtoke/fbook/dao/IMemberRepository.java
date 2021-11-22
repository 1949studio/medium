package me.mrtoke.fbook.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import me.mrtoke.fbook.entities.Member;

@RepositoryRestResource(collectionResourceRel="apimembers", path="members-api")
public interface IMemberRepository extends PagingAndSortingRepository<Member, Long>{
	@Override
	public List<Member> findAll();
	@Override
	public Page<Member> findAll(Pageable pageAndsize);
	
	public Member findMemberByEmail(String email);
	
	
}
