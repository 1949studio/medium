package me.mrtoke.fbook.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import me.mrtoke.fbook.entities.Article;

public interface IArticleRepository extends PagingAndSortingRepository<Article, Long> {

}
