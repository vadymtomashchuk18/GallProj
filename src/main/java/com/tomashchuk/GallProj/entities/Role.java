package com.tomashchuk.GallProj.entities;

public enum Role {
	ADMIN(1), SMPLUSER(2);
	int value;

	private Role(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}