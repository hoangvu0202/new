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
public class Catogory {
	private int categoryId;
	private String categoryName;
	
	
	public int getCategoryId() {
		return categoryId;
	}
	

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	

	public String getCategoryName() {
		return categoryName;
	}
	

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Catogory(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @param categoryId
	 * @param categoryName
	 */
	public Catogory(int categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	/**
	 * @param categoryId
	 * @param categoryName
	 */
	public Catogory() {
	}
	
}
