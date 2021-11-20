package me.mrtoke.fbook.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_seq")
	@SequenceGenerator(name="comment_seq", allocationSize=1)
	private long id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Article article;
	private int likesCount;
	private String content;
	private Date commentedDate;
	
	public Comment() {
		
	}

	public Comment(User user, String content, Date commentedDate) {
		super();
		this.user = user;
		this.content = content;
		this.commentedDate = commentedDate;
		this.likesCount = 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCommentedDate() {
		return commentedDate;
	}

	public void setCommentedDate(Date commentedDate) {
		this.commentedDate = commentedDate;
	}
	
	
}
