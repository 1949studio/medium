package me.mrtoke.fbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="writer")
public class Writer extends Member{
	@OneToMany(cascade= { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH }, mappedBy="author")
	@JsonIgnore
	private List<Article> articles;
	public Writer() {
		super();
	}
	public Writer(String username, String firstName, String lastName, String email, String password) {
		super(username, firstName, lastName, email, password);
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
