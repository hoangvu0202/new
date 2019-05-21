/**
 * 
 */
package com.vu.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vu.entity.Customer;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class CustomerImp implements CustomerDao {

	private final MysqlConnection con= new MysqlConnection();
	
	@Override
	public boolean insertCustomer(Customer customer) {
        String sql= "insert into customers(customerid, password, email) values(?,?,?)";
        try {
            PreparedStatement ps= con.getConnection().prepareCall(sql);
            ps.setString(1, customer.getCustomerId());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getEmail());
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
	}

	@Override
	public boolean editCustomer(Customer customer) {
		return false;
	}

	@Override
	public boolean deleteCustomer(String customer) {
		return false;
	}

	@Override
	public List<Customer> listCus() {
		return null;
	}

	@Override
	public Customer findById(String id) throws SQLException {
		return null;
	}

	@Override
	public Customer findByName(String name) throws SQLException {
		return null;
	}

}
