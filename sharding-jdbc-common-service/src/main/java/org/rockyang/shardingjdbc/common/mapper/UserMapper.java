package org.rockyang.shardingjdbc.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.rockyang.shardingjdbc.common.model.User;

import java.util.List;

/**
 * @author l.k
 */
@Mapper
public interface UserMapper {

	/**
	 * add a new user
	 * @param model
	 * @return
	 */
	Integer insert(User model);

	/**
	 * select all users
	 * @return
	 */
	List<User> selectAll();


	List<User> select(String username);
}
