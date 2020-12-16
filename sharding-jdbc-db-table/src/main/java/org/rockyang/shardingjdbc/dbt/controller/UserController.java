package org.rockyang.shardingjdbc.dbt.controller;

import com.google.common.base.Preconditions;
import org.rockyang.shardingjdbc.common.model.User;
import org.rockyang.shardingjdbc.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * user controller
 * @author l.k
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/add")
	public Integer insertUser(String username, String password)
	{
		Preconditions.checkNotNull(username, "username is need.");
		Preconditions.checkNotNull(password, "password is need.");
		User user = new User(username, password);
		return userService.add(user);
	}

	@GetMapping("/select")
	public List<User> selectAll()
	{
		return userService.selectAll();
	}
}
