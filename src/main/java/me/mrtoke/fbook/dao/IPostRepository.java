package me.mrtoke.fbook.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import me.mrtoke.fbook.entities.Post;

public interface IPostRepository extends CrudRepository<Post, Long> {
	@Override
	public List<Post> findAll();
	
	@Query("FROM POSTS p WHERE p.user_id = :userId")
	public List<Post> findByUserUserId(@Param("userId") Long userId);
	
	
}
