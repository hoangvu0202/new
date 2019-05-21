/**
 * 
 */
package com.vu.dao;

import java.sql.SQLException;
import java.util.List;

import com.vu.entity.Orderdetail;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public interface OrderDetailDao {

    abstract public boolean addOrderDetail(Orderdetail detail);
    abstract public boolean editOrderDetail(Orderdetail detail);
    abstract public boolean deleteOrderDetail(int tail);
    abstract public List<Orderdetail> listTail()throws SQLException;
    abstract public Orderdetail findById(int id) throws SQLException;
    abstract public Orderdetail findByName(String name) throws SQLException;
}
