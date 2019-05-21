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

import com.vu.entity.Product;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class ProductImp implements ProductDao {

	private final MysqlConnection con= new MysqlConnection();

	@Override
	public boolean addProduct(Product pro) {
        String sql="insert into product(categoryid,productname,"
                + "quanlity,price,note,picture) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.getConnection().prepareCall(sql);
            ps.setInt(1, pro.getCategoryId());
            ps.setString(2, pro.getProductName());
            ps.setInt(3, pro.getQuantity());
            ps.setFloat(4, pro.getPrice());
            ps.setString(5, pro.getNote());
            ps.setString(6, pro.getPicture());
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
	}

	@Override
	public boolean editProduct(Product pro) {
		return false;
	}

	@Override
	public boolean deleteProduct(int pro) {
		return false;
	}

	@Override
	public Product findByName(String name) throws SQLException {
		return null;
	}

	@Override
	public Product findById(int id) throws SQLException {
        String sql= "select * from product where productid=?";
        PreparedStatement ps= con.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
        Product pro= new Product();
            pro.setProductId(rs.getInt("productid"));
            pro.setCategoryId(rs.getInt("categoryid"));
            pro.setPrice(rs.getFloat("price"));
            pro.setQuantity(rs.getInt("quanlity"));
            pro.setProductName(rs.getString("productname"));
            pro.setNote(rs.getString("note"));
            pro.setPicture(rs.getString("picture"));
        return pro;
    }
        return null;
	}

	@Override
	public List<Product> listProduct() throws SQLException {
        List<Product> getListPro = new ArrayList<>();
        String sql="select * from product";
        PreparedStatement ps= con.getConnection().prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            Product pro= new Product();
            pro.setProductId(rs.getInt("productid"));
            pro.setCategoryId(rs.getInt("categoryid"));
            pro.setPrice(rs.getFloat("price"));
            pro.setQuantity(rs.getInt("quanlity"));
            pro.setProductName(rs.getString("productname"));
            pro.setNote(rs.getString("note"));
            pro.setPicture(rs.getString("picture"));
            getListPro.add(pro);
        }
        return getListPro;
	}

	@Override
	public List<Product> getListProduct(int cateid) throws SQLException {
        String sql= "select * from product where product.categoryid=?";
        List<Product> getPro= new ArrayList<>();
        PreparedStatement ps= con.getConnection().prepareStatement(sql);
        ps.setInt(1, cateid);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            Product p= new Product();
            p.setProductId(rs.getInt("productid"));
            p.setCategoryId(rs.getInt("categoryid"));
            p.setPrice(rs.getFloat("price"));
            p.setQuantity(rs.getInt("quanlity"));
            p.setProductName(rs.getString("productname"));
            p.setNote(rs.getString("note"));
            p.setPicture(rs.getString("picture"));
            getPro.add(p);
        }
        return getPro;
	}

	@Override
	public int countProduct() throws SQLException {
        String sql= "select count(*) as dem from product";
        int count =0;
        PreparedStatement ps= con.getConnection().prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            count= rs.getInt(1);
        }
        return count;
	}

	//pages first limit (paper-1)*10, 10
	@Override
	public List<Product> getListByPaper(int first, int last) throws SQLException {
        String sql= "select *  from product limit ?,?";
        List<Product> getPro= new ArrayList<>();
        PreparedStatement ps= con.getConnection().prepareStatement(sql);
        ps.setInt(1, first);
        ps.setInt(2, last);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
        	Product p= new Product();
        	p.setProductId(rs.getInt("productid"));
        	p.setCategoryId(rs.getInt("categoryid"));
        	p.setPrice(rs.getFloat("price"));
        	p.setQuantity(rs.getInt("quanlity"));
        	p.setProductName(rs.getString("productname"));
        	p.setNote(rs.getString("note"));
        	p.setPicture(rs.getString("picture"));
        	getPro.add(p);
        }
        return getPro;
	}
	
    public static void main(String[] args) throws SQLException {
    ProductImp p= new ProductImp();
    for(Product c: p.listProduct()){
        System.out.println(""+c.getProductName());
    }
        System.out.println(""+ p.countProduct());
}

}
