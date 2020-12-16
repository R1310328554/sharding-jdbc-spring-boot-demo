package org.rockyang.shardingjdbc.common.service.impl;

import org.rockyang.shardingjdbc.common.mapper.UserMapper;
import org.rockyang.shardingjdbc.common.service.UserService;
import org.rockyang.shardingjdbc.common.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * order service implementation
 * @author l.k
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserMapper userMapper;

	@Override
	public Integer add(User user) {
		return userMapper.insert(user);
	}

	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public List<User> select(String username) {
		return userMapper.select(username);
	}
}
