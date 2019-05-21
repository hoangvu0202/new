/**
 * 
 */
package com.vu.services;

import java.sql.SQLException;
import java.util.List;

import com.vu.dao.CategoryImp;
import com.vu.entity.Catogory;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class CategoryServiceImp implements CategoryService {

	private CategoryImp categoryImp;

	public CategoryServiceImp() {
		this.categoryImp = new CategoryImp(); 
	}
	
	@Override
	public boolean addCategory(Catogory cate) {
		return categoryImp.addCategory(cate);
	}

	@Override
	public boolean editCategory(Catogory cate) {
		return categoryImp.editCategory(cate);
	}

	@Override
	public boolean deleteCategory(int cate) {
		return categoryImp.deleteCategory(cate);
	}

	@Override
	public Catogory findbyId(int id) throws SQLException {
		return categoryImp.findbyId(id);
	}

	@Override
	public Catogory findByName(String name) throws SQLException {
		return categoryImp.findByName(name);
	}

	@Override
	public List<Catogory> getListCat() {
		return categoryImp.getListCat();
	}
	public static void main(String[] args) {
		CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
		System.out.println(categoryServiceImp.getListCat());
	}

}
