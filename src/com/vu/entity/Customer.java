/**
 * 
 */
package com.vu.entity;

/**
 * @author VUNH
 *
 * Apr 11, 2019
 * 
 * version 1.0
 */
public class Customer {
	
    private String customerId;
    private String customerName;
    private String email;
	private String fullname;
    private String sex;
    private boolean actived;
    
    /**
	 * @param customerId
	 * @param customerName
	 * @param email
	 * @param fullname
	 * @param sex
	 * @param actived
	 */
	public Customer(String customerId, String customerName, String email, String fullname, String sex,
			boolean actived) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.fullname = fullname;
		this.sex = sex;
		this.actived = actived;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public boolean isActived() {
		return actived;
	}


	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	
}
