package org.rockyang.shardingjdbc.common.service;

import org.rockyang.shardingjdbc.common.model.Order;

import java.util.List;

/**
 * @author l.k
 */
public interface OrderService {

	/**
	 * add a new order
	 * @param order
	 * @return update affect rows
	 */
	Integer add(Order order);

	/**
	 * select all orders
	 * @return
	 */
	List<Order> selectAll();
}
