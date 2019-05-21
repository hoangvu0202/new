/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.entity;

import java.sql.Timestamp;

/**
 * 
 * @author VUNH
 *
 * Apr 11, 2019
 * 
 * version 1.0
 */
public class Order {
	private long orderId;
	private String customerId;
	private Timestamp orderDate;
	private Timestamp requireDate;
	private String received;
	private String address;
	private String description;
	private float amount;

	public Order(long orderId, String customerId, Timestamp orderDate, Timestamp requireDate, String received,
			String address, String description, float amount) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.requireDate = requireDate;
		this.received = received;
		this.address = address;
		this.description = description;
		this.amount = amount;
	}

	public Order(String customerId, Timestamp orderDate, Timestamp requireDate, String received, String address,
			String description, float amount) {
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.requireDate = requireDate;
		this.received = received;
		this.address = address;
		this.description = description;
		this.amount = amount;
	}

	public Order() {
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getRequireDate() {
		return requireDate;
	}

	public void setRequireDate(Timestamp requireDate) {
		this.requireDate = requireDate;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
