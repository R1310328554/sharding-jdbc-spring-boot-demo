package org.rockyang.shardingjdbc.cusalgo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rockyang.shardingjdbc.common.model.Order;
import org.rockyang.shardingjdbc.common.service.OrderService;
import org.rockyang.shardingjdbc.common.utils.Snowflake;
import org.rockyang.shardingjdbc.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author l.k
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	private static Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);

	@Resource
	private OrderService orderService;

	@Test
	public void testAdd()
	{
		Long userId = 361116122344325121L;
		Order order = new Order(Snowflake.getInstance().nextId(), userId);
		order.setTitle(StringUtil.generateRandomString(20));
		if (orderService.add(order) > 0) {
			logger.info("OrderId: {}", order.getOrderId());
		}
	}

	@Test
	public void testBatchAdd()
	{
		Long userId = 361116122344325121L;
		for (int i = 0; i < 100; i++) {
			Order order = new Order(Snowflake.getInstance().nextId(), userId);
			order.setTitle(StringUtil.generateRandomString(20));
			if (orderService.add(order) > 0) {
				logger.info("OrderId: {}", order.getOrderId());
			}
		}

	}

	@Test
	public void testSelect()
	{
		List<Order> orders = orderService.selectAll();
		logger.info("Total records: {}", orders.size());
		for (Order order : orders) {
			logger.info("{}", order);
		}
	}
}
