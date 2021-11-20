package me.mrtoke.fbook.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="post_seq")
	@SequenceGenerator(name="post_seq", allocationSize=1)
	private long postId;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	private String message;
	
	@CreatedDate
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIME")
	private Date createdTime;
	
	private String mediaURL;
	
	public Post() {
	}
	
	public Post(User user, String message, String mediaURL) {
		super();
		this.user = user;
		this.message = message;
		this.mediaURL = mediaURL;
	}
	
	

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getMediaURL() {
		return mediaURL;
	}

	public void setMedialURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	
	
}
