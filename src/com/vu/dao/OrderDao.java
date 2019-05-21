/**
 * 
 */
package com.vu.dao;

import java.sql.SQLException;
import java.util.List;

import com.vu.entity.Order;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public interface OrderDao {
    abstract public boolean insert(Order order);
    abstract public boolean editOrder(Order order);
    abstract public boolean deleteOrder(long order);
    abstract public Order findByName(String name) throws SQLException;
    abstract public Order findById(long id) throws SQLException;
    abstract public List<Order> listOrder()throws SQLException;

}
