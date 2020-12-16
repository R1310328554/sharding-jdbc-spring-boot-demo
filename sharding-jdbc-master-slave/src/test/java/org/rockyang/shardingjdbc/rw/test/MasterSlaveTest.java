package org.rockyang.shardingjdbc.rw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rockyang.shardingjdbc.common.model.User;
import org.rockyang.shardingjdbc.common.service.UserService;
import org.rockyang.shardingjdbc.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author l.k
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterSlaveTest {

	private static Logger logger = LoggerFactory.getLogger(MasterSlaveTest.class);

	@Autowired
	private UserService userService;

	@Test
	public void testAdd()
	{
		String username = StringUtil.generateRandomString(20);
		String password = StringUtil.generateRandomString(20);
		User user = new User(username, password);
		userService.add(user);
		logger.info("userId: {}", user.getUserId());
	}

	@Test
	public void testAddBatch()
	{
		String username;
		String password;
		for (int i = 0; i < 100; i++) {
			username = StringUtil.generateRandomString(20);
			password = StringUtil.generateRandomString(20);
			User user = new User(username, password);
			userService.add(user);
			logger.info("userId: {}", user.getUserId());
		}
	}

	@Test
	public void testSelect()
	{
		List<User> users = userService.selectAll();
		logger.info("Total records: {}", users.size());
		for (User user : users) {
			logger.info("{}", user);
		}
	}
}
