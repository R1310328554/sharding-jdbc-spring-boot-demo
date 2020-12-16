package org.rockyang.shardingjdbc.cusalgo.controller;

import com.google.common.base.Preconditions;
import org.rockyang.shardingjdbc.common.model.Order;
import org.rockyang.shardingjdbc.common.service.OrderService;
import org.rockyang.shardingjdbc.common.utils.Snowflake;
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
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/add")
	public Long insertOrder(Long userId)
	{
		Preconditions.checkNotNull(userId, "userId is need.");

		Order order = new Order(Snowflake.getInstance().nextId(), userId);
		if (orderService.add(order) > 0) {
			return order.getOrderId();
		} else {
			return null;
		}
	}

	@GetMapping("/select")
	public List<Order> select()
	{
		return orderService.selectAll();
	}

}
