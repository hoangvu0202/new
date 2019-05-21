/**
 * 
 */
package com.vu.dao;

import java.sql.SQLException;
import java.util.List;

import com.vu.entity.Customer;


/**
 * @author VUNH
 *
 * Apr 11, 2019
 * 
 * version 1.0
 */
public interface CustomerDao {
    abstract public boolean insertCustomer(Customer customer);
    abstract public boolean editCustomer(Customer customer);
    abstract public boolean deleteCustomer(String customer);
    abstract public List<Customer> listCus();
    abstract public Customer findById(String id)throws SQLException;
    abstract public Customer findByName(String name)throws SQLException;
}
