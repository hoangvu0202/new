/**
 * 
 */
package com.vu.dao;

import java.sql.SQLException;
import java.util.List;

import com.vu.entity.Catogory;


/**
 * @author VUNH
 *
 * Apr 11, 2019
 * 
 * version 1.0
 */
public interface CategoryDao {
    abstract public boolean addCategory(Catogory cate);
    abstract public boolean editCategory(Catogory cate);
    abstract public boolean deleteCategory(int cate);
    abstract public Catogory findbyId(int id) throws SQLException;
    abstract public Catogory findByName(String name) throws SQLException;
    abstract public List<Catogory> getListCat();
}
