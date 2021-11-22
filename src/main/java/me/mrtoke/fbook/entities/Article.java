package me.mrtoke.fbook.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="article_seq")
	@SequenceGenerator(name="article_seq", allocationSize=1)
	private long id;
	private ArticleGenre genre;
	private String title;
	@ManyToOne
	@JoinColumn(name="user_id")
	private Writer author;
	private Date createdDate;
	private boolean isDraft;
	private Date publishedDate;
	// an article is made up of many components
	//which could be images/text/videos/embedded html
	@OneToMany(mappedBy="article")
	private List<Component> components;
	
	public Article() {
		
	}
	
	public Article(ArticleGenre genre, String title, Writer author, Date createdDate, boolean isDraft,
			Date publishedDate) {
		super();
		this.genre = genre;
		this.title = title;
		this.author = author;
		this.createdDate = createdDate;
		this.isDraft = isDraft;
		this.publishedDate = publishedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArticleGenre getGenre() {
		return genre;
	}

	public void setGenre(ArticleGenre genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Writer getAuthor() {
		return author;
	}

	public void setAuthor(Writer author) {
		this.author = author;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isDraft() {
		return isDraft;
	}

	public void setDraft(boolean isDraft) {
		this.isDraft = isDraft;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	
	
}
