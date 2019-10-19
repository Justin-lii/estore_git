package com.briup.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 定义该类，能够对外提供获取Connection对象，
 * 获取Statement对象等方法；提供关闭相关对象的方法。
 */
public class DBUtils{
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	public static void main(String[] args) {
		System.out.println("连接数据库");
		try {
			//测试数据库是否连接成功
			System.out.println(getConn());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static{
		try{
			Properties properties=new Properties();
			InputStream is=
				DBUtils.class.getResourceAsStream("db.properties");
			properties.load(is);
			
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
			
			Class.forName(driver);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	
	public static Statement getStat() throws SQLException{
		return getConn().createStatement();
	}
	
	public static PreparedStatement getPstat(String sql) throws SQLException{
		return getConn().prepareStatement(sql);
	}
	
	public void close(
		ResultSet resultSet,
		Statement statement,
		Connection connection){
		
		try{
			if(resultSet!=null) resultSet.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(statement!=null) statement.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(connection!=null) connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
