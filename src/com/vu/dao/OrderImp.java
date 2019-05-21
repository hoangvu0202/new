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

import com.vu.entity.Order;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class OrderImp implements OrderDao {

	private final MysqlConnection con= new MysqlConnection();
	
	@Override
    public boolean insert(Order order) {
        String sql="insert into orders(orders.orderid,orders.customerid, orders.orderdate,"
                + " orders.requiredate, orders.receiver, orders.address, orders.description, orders.amount) values(?,?,?,?,?,?,?,?)";
    try {
        PreparedStatement ps= con.getConnection().prepareCall(sql);
        ps.setLong(1, order.getOrderId());
        ps.setString(2, order.getCustomerId());
        ps.setTimestamp(3, order.getOrderDate());
        ps.setTimestamp(4, order.getRequireDate());
        ps.setString(5, order.getReceived());
        ps.setString(6, order.getAddress());
        ps.setString(7, order.getDescription());
        ps.setFloat(8, order.getAmount());
        return ps.executeUpdate()==1;
        
    } catch (SQLException ex) {
        Logger.getLogger(OrderImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}

@Override
public boolean editOrder(Order order) {
    String sql="update orders set customerid=?,orderdate=?,requiredate=?,receiver=?,address=?,description=?,amount=? where orderid=? ";
    try {
        PreparedStatement ps= con.getConnection().prepareCall(sql);
        ps.setLong(8, order.getOrderId());
        ps.setString(1, order.getCustomerId());
        ps.setTimestamp(2, order.getOrderDate());
        ps.setTimestamp(3, order.getRequireDate());
        ps.setString(4, order.getReceived());
        ps.setString(5, order.getAddress());
        ps.setString(6, order.getDescription());
        ps.setFloat(7, order.getAmount());
        return ps.executeUpdate()==1;
    } catch (SQLException ex) {
        Logger.getLogger(OrderImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return false;
}

@Override
public boolean deleteOrder(long order) {
    try {
        String sql="delete from orders where orderid=?";
        PreparedStatement ps= con.getConnection().prepareCall(sql);
        ps.setLong(1, order);
        return ps.executeUpdate()==1;
    } catch (SQLException ex) {
        Logger.getLogger(OrderImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}

@Override
public Order findByName(String name) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); 
}

@Override
public Order findById(long id) throws SQLException {
    String sql= "select * from orders where orders.orderid=?";
    PreparedStatement ps= con.getConnection().prepareStatement(sql);
    ps.setLong(1, id);
    ResultSet rs= ps.executeQuery();
    while(rs.next()){
        Order order= new Order();
        order.setOrderId(rs.getInt("orderid"));
        order.setCustomerId(rs.getString("customerid"));
        order.setOrderDate(rs.getTimestamp("orderdate"));
        order.setRequireDate(rs.getTimestamp("requiredate"));
        order.setReceived(rs.getString("receiver"));
        order.setAddress(rs.getString("address"));
        order.setDescription(rs.getString("description"));
        order.setAmount(rs.getFloat("amount"));
        return order;
    }
    return null;
}
public Order findcus(String name)throws SQLException{
    String sql= "select * from orders where orders.customerid=?";
    PreparedStatement ps= con.getConnection().prepareStatement(sql);
    ps.setString(1, name);
    ResultSet rs= ps.executeQuery();
    while(rs.next()){
        Order order= new Order();
        order.setOrderId(rs.getInt("orderid"));
        order.setCustomerId(rs.getString("customerid"));
        order.setOrderDate(rs.getTimestamp("orderdate"));
        order.setRequireDate(rs.getTimestamp("requiredate"));
        order.setReceived(rs.getString("receiver"));
        order.setAddress(rs.getString("address"));
        order.setDescription(rs.getString("description"));
        order.setAmount(rs.getFloat("amount"));
        return order;
    }
    return null;
}

@Override
public List<Order> listOrder()throws SQLException {
    List<Order> listOrder= new ArrayList<>();
    String sql="select * from orders";
    PreparedStatement ps= con.getConnection().prepareStatement(sql);
    ResultSet rs= ps.executeQuery();
    while(rs.next()){
        Order order= new Order();
        order.setOrderId(rs.getInt("orderid"));
        order.setCustomerId(rs.getString("customerid"));
        order.setOrderDate(rs.getTimestamp("orderdate"));
        order.setRequireDate(rs.getTimestamp("requiredate"));
        order.setReceived(rs.getString("receiver"));
        order.setAddress(rs.getString("address"));
        order.setDescription(rs.getString("description"));
        order.setAmount(rs.getFloat("amount"));
        listOrder.add(order);
    }
    return listOrder;
}
public static void main(String[] args) throws SQLException {
    OrderImp ore= new OrderImp();
    for(Order o: ore.listOrder()){
        System.out.println("-------"+o.getCustomerId());
    }
}

}
