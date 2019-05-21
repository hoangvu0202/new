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
public class Product {
	private int productId;
	private int categoryId;
    private String productName;
    private float price;
    private int quantity;
    private String note;
	private String picture;
	
    /**
	 * @param productId
	 * @param categoryId
	 * @param productName
	 * @param price
	 * @param quantity
	 * @param note
	 * @param picture
	 */
	public Product(int productId, int categoryId, String productName, float price, int quantity, String note,
			String picture) {
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.note = note;
		this.picture = picture;
	}
	
	public Product() {}

	/**
	 * @param categoryId
	 * @param productName
	 * @param price
	 * @param quantity
	 * @param note
	 * @param picture
	 */
	public Product(int categoryId, String productName, float price, int quantity, String note, String picture) {
		super();
		this.categoryId = categoryId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.note = note;
		this.picture = picture;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}
	

}
