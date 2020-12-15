package com.budz.models;

import java.io.Serializable;

public class RelationshipId implements Serializable {

	private int userOneId;
	private int userTwoId;
	
	public RelationshipId() {
		
	}
	
	public RelationshipId(int userOneId, int userTwoId) {
		this.userOneId = userOneId;
		this.userTwoId = userTwoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userOneId;
		result = prime * result + userTwoId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelationshipId other = (RelationshipId) obj;
		if (userOneId != other.userOneId)
			return false;
		if (userTwoId != other.userTwoId)
			return false;
		return true;
	}
	
	

}
