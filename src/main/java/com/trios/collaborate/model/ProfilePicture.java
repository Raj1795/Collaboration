package com.trios.collaborate.model;

import javax.persistence.*;

@Entity
@Table
public class ProfilePicture {

	@Id
	private String userId;
	@Lob
	private byte[] image;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
