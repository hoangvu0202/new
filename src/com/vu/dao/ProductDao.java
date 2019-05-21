/**
 * 
 */
package com.vu.dao;

import java.sql.SQLException;
import java.util.List;

import com.vu.entity.Product;


/**
 * @author VUNH
 *
 * Apr 11, 2019
 * 
 * version 1.0
 */
public interface ProductDao {
    abstract public boolean addProduct(Product pro);
    abstract public boolean editProduct(Product pro);
    abstract public boolean deleteProduct(int pro);
    abstract public Product findByName(String name) throws SQLException;
    abstract public Product findById(int id) throws SQLException;
    abstract public List<Product> listProduct() throws SQLException;
    abstract public List<Product> getListProduct(int cateid) throws SQLException;
    abstract public int countProduct()throws SQLException;
    abstract public List<Product> getListByPaper(int first, int last)throws SQLException;

}
