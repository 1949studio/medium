package me.mrtoke.fbook.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import me.mrtoke.fbook.entities.Comment;

public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
	
}
