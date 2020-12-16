package org.rockyang.shardingjdbc.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.rockyang.shardingjdbc.common.model.Order;

import java.util.List;

/**
 * @author l.k
 */
@Mapper
public interface OrderMapper {

	/**
	 * add a new order
	 * @param model
	 * @return
	 */
	Integer insert(Order model);

	/**
	 * select all orders
	 * @return
	 */
	List<Order> selectAll();
}
