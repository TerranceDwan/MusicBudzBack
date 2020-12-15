package com.budz.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(RelationshipId.class)
public class Relationship {
	
	@Id
	private int userOneId;
	@Id
	private int userTwoId;
	private int status;
	private int actionUserId;
	
	
	public int getUserOneId() {
		return userOneId;
	}
	public void setUserOneId(int userOneId) {
		this.userOneId = userOneId;
	}
	public int getUserTwoId() {
		return userTwoId;
	}
	public void setUserTwoId(int userTwoId) {
		this.userTwoId = userTwoId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getActionUserId() {
		return actionUserId;
	}
	public void setActionUserId(int actionUserId) {
		this.actionUserId = actionUserId;
	}
	
	public Relationship() {
		super();
	}
	
	public Relationship(int userOneId, int userTwoId, int status, int actionUserId) {
		super();
		this.userOneId = userOneId;
		this.userTwoId = userTwoId;
		this.status = status;
		this.actionUserId = actionUserId;
	}
	
	

}
