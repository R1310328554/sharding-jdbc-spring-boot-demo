package org.rockyang.shardingjdbc.common.service;

import org.rockyang.shardingjdbc.common.model.User;

import java.util.List;

/**
 * @author l.k
 */
public interface UserService {

	/**
	 * add a new user
	 * @param user
	 * @return
	 */
	Integer add(User user);

	/**
	 * select all users
	 * @return
	 */
	List<User> selectAll();


	List<User> select(String username);
}
