/**
 * 
 */
package com.vu.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author VUNH
 *
 * Apr 11, 2019
 * 
 * version 1.0
 */
public class MysqlConnection {

	String filename = "mysqlconfig.properties";
	public Connection getConnection() {
		Properties properties=  new Properties();
		Connection cnn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			InputStream input = getClass().getClassLoader().getResourceAsStream(filename);
			properties.load(input);
			String uri = properties.getProperty("uri");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			System.out.println(user+uri+"\n"+password);
			cnn = (Connection) DriverManager.getConnection(uri, user, password);
		} catch (ClassNotFoundException | SQLException |  IOException e) {
			System.out.println("disconnection");
			System.out.println(e.getMessage());
		}
		return cnn;
	}

	public static void main(String[] args) {

		System.out.println("connection:  " + new MysqlConnection().getConnection());
	}

}

