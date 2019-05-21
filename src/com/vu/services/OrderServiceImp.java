/**
 * 
 */
package com.vu.services;

import java.sql.SQLException;
import java.util.List;

import com.vu.dao.OrderImp;
import com.vu.entity.Order;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class OrderServiceImp implements OrderService {

	private OrderImp orderImp;
	
	public OrderServiceImp() {
		this.orderImp = new OrderImp();
	}
	
	@Override
	public boolean insert(Order order) {
		return orderImp.insert(order);
	}

	@Override
	public boolean editOrder(Order order) {
		return orderImp.editOrder(order);
	}

	@Override
	public boolean deleteOrder(long order) {
		return orderImp.deleteOrder(order);
	}

	@Override
	public Order findByName(String name) throws SQLException {
		return orderImp.findByName(name);
	}

	@Override
	public Order findById(long id) throws SQLException {
		return orderImp.findById(id);
	}

	@Override
	public List<Order> listOrder() throws SQLException {
		return orderImp.listOrder();
	}

}
