package org.rockyang.shardingjdbc.common.service.impl;

import org.rockyang.shardingjdbc.common.mapper.OrderMapper;
import org.rockyang.shardingjdbc.common.model.Order;
import org.rockyang.shardingjdbc.common.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * user service implementation
 * @author l.k
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderMapper orderMapper;

	@Override
	public Integer add(Order order)
	{
		return orderMapper.insert(order);
	}

	@Override
	public List<Order> selectAll() {
		return orderMapper.selectAll();
	}
}
