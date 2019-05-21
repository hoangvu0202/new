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

import com.vu.entity.Orderdetail;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class OrderDetailImp implements OrderDetailDao {

	private final MysqlConnection con= new MysqlConnection();
	
    public boolean addOrderDetail(Orderdetail detail) {
    	String sql="insert into orderdetails(orderid, productid, unitprice, quantity, discount) values(?,?,?,?,?)";
    	try {
    		PreparedStatement ps= (PreparedStatement) con.getConnection().prepareCall(sql);
    		ps.setLong(1, detail.getOrderID());
    		ps.setInt(2, detail.getProductID());
    		ps.setFloat(3, detail.getUnitprice());
    		ps.setFloat(4, detail.getQuantity());
    		ps.setFloat(5, detail.getDiscount());
    		return ps.executeUpdate()==1;
    	} catch (SQLException ex) {
    		Logger.getLogger(OrderDetailImp.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	
    	return false;
    }
    
    @Override
    public boolean editOrderDetail(Orderdetail detail) {
    	String sql="update orderdetails set orderid=?, productid=?, unitprice=?,quantity=?,discount=? where id=?";
    	try {
    		PreparedStatement ps= con.getConnection().prepareCall(sql);
    		ps.setLong(1, detail.getOrderID());
    		ps.setInt(2, detail.getProductID());
    		ps.setFloat(3, detail.getUnitprice());
    		ps.setInt(4, detail.getQuantity());
    		ps.setFloat(5, detail.getDiscount());
    		ps.setLong(6, detail.getId());
    		return ps.executeUpdate()==1;
    	} catch (SQLException ex) {
    		Logger.getLogger(OrderDetailImp.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	return false;
    }
    
    @Override
    public boolean deleteOrderDetail(int tail) {
    	String sql="delete from orderdetails where id=?";
    	try {
    		PreparedStatement ps= con.getConnection().prepareCall(sql);
    		ps.setInt(1, tail);
    		return ps.executeUpdate()==1;
    	} catch (SQLException ex) {
    		Logger.getLogger(OrderDetailImp.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	return false;
    }
    
    @Override
    public List<Orderdetail> listTail() throws SQLException {
    	List<Orderdetail> listDetail= new ArrayList<>();
    	String sql="select * from ordertails";
    	PreparedStatement ps= con.getConnection().prepareStatement(sql);
    	ResultSet rs= ps.executeQuery();
    	while(rs.next()){
    		Orderdetail detail= new Orderdetail();
    		detail.setId(rs.getInt("id"));
    		detail.setOrderID(rs.getInt("orderid"));
    		detail.setProductID(rs.getInt("productid"));
    		detail.setUnitprice(rs.getFloat("unitprice"));
    		detail.setQuantity(rs.getInt("quantity"));
    		detail.setDiscount(rs.getFloat("discount"));
    		listDetail.add(detail);
    	}
    	return listDetail;
    }
    
    @Override
    public Orderdetail findById(int id) throws SQLException {
    	String sql="select * from orderdetails where id=?";
    	PreparedStatement ps= con.getConnection().prepareCall(sql);
    	ps.setInt(1, id);
    	ResultSet rs= ps.executeQuery();
    	while(rs.next()){
    		Orderdetail detail= new Orderdetail();
    		detail.setId(rs.getInt("id"));
    		detail.setOrderID(rs.getInt("orderid"));
    		detail.setProductID(rs.getInt("productid"));
    		detail.setUnitprice(rs.getFloat("unitprice"));
    		detail.setQuantity(rs.getInt("quantity"));
    		detail.setDiscount(rs.getFloat("discount"));
    		return detail;
    	}
    	return null;
    }

	@Override
	public Orderdetail findByName(String name) throws SQLException {
		//String sql="select * from orderdetail like '%?%'";
		return null;
	}

}
