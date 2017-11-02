package com.trios.collaborate.model;

import java.util.Date;

import javax.persistence.*;

@Table
@Entity
public class BlogComment {
 
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	private String commentText;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getCommentedOn() {
		return commentedOn;
	}

	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}

	public User getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(User commentedBy) {
		this.commentedBy = commentedBy;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	private Date commentedOn;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User commentedBy;
	
	@ManyToOne
	private Blog blog;
	
}
