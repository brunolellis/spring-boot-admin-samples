package com.brunolellis.user.api;

import java.util.List;

public class Users {
	private List<User> users;

	public Users(User... users) {
		this.users = List.of(users);
	}

	public List<User> getUsers() {
		return this.users;
	}
}
