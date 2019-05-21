/**
 * 
 */
package com.vu.services;

import java.sql.SQLException;
import java.util.List;

import com.vu.dao.OrderDetailImp;
import com.vu.entity.Orderdetail;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class OrderDetailServeceImp implements OrderDetailService{
	
	private OrderDetailImp orderDetailImp;

	public OrderDetailServeceImp() {
		this.orderDetailImp = new OrderDetailImp();
	}
	
	@Override
	public boolean addOrderDetail(Orderdetail detail) {
		return orderDetailImp.addOrderDetail(detail);
	}


	@Override
	public boolean editOrderDetail(Orderdetail detail) {
		return orderDetailImp.editOrderDetail(detail);
	}


	@Override
	public boolean deleteOrderDetail(int tail) {
		return orderDetailImp.deleteOrderDetail(tail);
	}


	@Override
	public List<Orderdetail> listTail() throws SQLException {
		return orderDetailImp.listTail();
	}


	@Override
	public Orderdetail findById(int id) throws SQLException {
		return orderDetailImp.findById(id);
	}


	@Override
	public Orderdetail findByName(String name) throws SQLException {
		return orderDetailImp.findByName(name);
	}

}
