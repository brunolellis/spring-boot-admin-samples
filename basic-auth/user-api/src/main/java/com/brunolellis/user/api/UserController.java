package com.brunolellis.user.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/api/users")
	public Users get() {
		return new Users(new User("john"), new User("doe"));
	}

}
