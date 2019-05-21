/**
 * 
 */
package com.vu.services;

import java.sql.SQLException;
import java.util.List;

import com.vu.dao.CustomerImp;
import com.vu.entity.Customer;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class CustomerServiceImp implements CustomerService {

	private CustomerImp customerImp;
	
	public CustomerServiceImp() {
		this.customerImp = new CustomerImp();
	}
	
	@Override
	public boolean insertCustomer(Customer customer) {
		return customerImp.insertCustomer(customer);
	}

	@Override
	public boolean editCustomer(Customer customer) {
		return customerImp.editCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(String customer) {
		return customerImp.deleteCustomer(customer);
	}

	@Override
	public List<Customer> listCus() {
		return customerImp.listCus();
	}

	@Override
	public Customer findById(String id) throws SQLException {
		return customerImp.findById(id);
	}

	@Override
	public Customer findByName(String name) throws SQLException {
		return null;
	}

}
