/**
 * 
 */
package com.vu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vu.entity.Catogory;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class CategoryImp implements CategoryDao {

	private final MysqlConnection con= new MysqlConnection();
	@Override
	public boolean addCategory(Catogory cate) {
        String sql="insert into category(categoryid,categoryname) values(?,?)";
        try {
            PreparedStatement ps= con.getConnection().prepareCall(sql);
            ps.setInt(1, cate.getCategoryId());
            ps.setString(2, cate.getCategoryName());
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
	}

	@Override
	public boolean editCategory(Catogory cate) {
        String sql="update category set categoryname=? where categoryid= ?";
        try {
            PreparedStatement ps= con.getConnection().prepareCall(sql);
            ps.setString(1, cate.getCategoryName());
            ps.setInt(2, cate.getCategoryId());
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
	}

	@Override
	public boolean deleteCategory(int cate) {
        String sql= "delete from category where categoryid=?";
        try {
            PreparedStatement ps= con.getConnection().prepareCall(sql);
            ps.setInt(1, cate);
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
	}

	@Override
	public Catogory findbyId(int id) throws SQLException {
        String sql= "select * from category where categoryid=?";
        PreparedStatement ps= con.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
           Catogory cate= new Catogory();
           cate.setCategoryId(rs.getInt("categoryid"));
           cate.setCategoryName(rs.getString("categoryname"));
           return cate;
        }
        return null;
	}


	@Override
	public Catogory findByName(String name) throws SQLException {
        String sql="select * from category where categoryname=?";
        PreparedStatement ps= con.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            Catogory cate= new Catogory();
            cate.setCategoryId(rs.getInt("categoryid"));
            cate.setCategoryName(rs.getString("categoryname"));
            return cate;
        }
        return null;
	}

	@Override
	public List<Catogory> getListCat() {
        List<Catogory> listCate= new ArrayList<>();
        String sql= "select *from category";
        try {
            PreparedStatement ps= con.getConnection().prepareCall(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Catogory cate= new Catogory();
                cate.setCategoryId(rs.getInt("categoryid"));
                cate.setCategoryName(rs.getNString("categoryname"));
                listCate.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCate;
	}

}
