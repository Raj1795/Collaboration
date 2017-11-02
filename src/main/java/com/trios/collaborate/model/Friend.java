package com.trios.collaborate.model;

import javax.persistence.*;

@Entity
@Table
public class Friend {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int friendId;
	
	private String fromId;
	private char status;
	private String toId;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	
}
