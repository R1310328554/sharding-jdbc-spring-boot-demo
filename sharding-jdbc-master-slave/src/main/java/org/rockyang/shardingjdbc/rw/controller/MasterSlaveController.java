package org.rockyang.shardingjdbc.rw.controller;

import com.google.common.base.Preconditions;
import org.rockyang.shardingjdbc.common.model.User;
import org.rockyang.shardingjdbc.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Master and slave database test controller
 * @author l.k
 */
@RestController
@RequestMapping("/user")
public class MasterSlaveController {

	@Autowired
	private UserService userService;

	/**
	 *
	 http://localhost:8080/user/add/n1/w1
	 http://localhost:8080/user/add/n2/w2


	 * @return
	 */
	@GetMapping("/add/{username}/{password}")
	public Long add(@PathVariable String username, @PathVariable String password)
	{
		Preconditions.checkNotNull(username, "username is need.");
		Preconditions.checkNotNull(password, "password is need.");
		User user = new User(username, password);
		if (userService.add(user) > 0) {
			return user.getUserId();
		}
		return null;
	}

	/**
	 *
	 http://localhost:8080/user/selectAll

	 * @return
	 */
	@GetMapping("/selectAllselectAllselectAll")
	public List<User> selectAll()
	{
		return userService.selectAll();
	}

	/**
	 *
	 http://localhost:8080/user/select

	 * @return
	 */
	@GetMapping("/select/{username}")
	public List<User> select(@PathVariable String username)
	{
		return userService.select(username);
	}
}
