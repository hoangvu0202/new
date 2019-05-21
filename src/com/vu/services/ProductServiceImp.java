/**
 * 
 */
package com.vu.services;

import java.sql.SQLException;
import java.util.List;

import com.vu.dao.ProductImp;
import com.vu.entity.Product;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class ProductServiceImp implements ProductService {

	private ProductImp productImp;
	
	public ProductServiceImp() {
		this.productImp =  new ProductImp();
	}
	
	@Override
	public boolean addProduct(Product pro) {
		return productImp.addProduct(pro);
	}

	@Override
	public boolean editProduct(Product pro) {
		return productImp.editProduct(pro);
	}

	@Override
	public boolean deleteProduct(int pro) {
		return productImp.deleteProduct(pro);
	}

	@Override
	public Product findByName(String name) throws SQLException {
		return productImp.findByName(name);
	}

	@Override
	public Product findById(int id) throws SQLException {
		return productImp.findById(id);
	}

	@Override
	public List<Product> listProduct() throws SQLException {
		return productImp.listProduct();
	}

	@Override
	public List<Product> getListProduct(int cateid) throws SQLException {
		return productImp.getListProduct(cateid);
	}

	@Override
	public int countProduct() throws SQLException {
		return productImp.countProduct();
	}

	@Override
	public List<Product> getListByPaper(int first, int last) throws SQLException {
		return productImp.getListByPaper(first, last);
	}

}
