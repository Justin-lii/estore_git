package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.bean.Customer;
import com.briup.dao.CustomerDao;
import com.briup.util.DBUtils;
import com.sun.xml.internal.ws.message.MimeAttachmentSet;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void insertCustomer(Customer customer) {
		try {
			String sql="insert into ES_CUSTOMER values("
					+ "my_seq.nextval,?,?,?,?,?)";
			PreparedStatement pstat = DBUtils.getPstat(sql);
			pstat.setString(1, customer.getUsername());
			pstat.setString(2, customer.getPassword());
			pstat.setString(3, customer.getZip());
			pstat.setString(4, customer.getPhone());
			pstat.setString(5, customer.getEmail());
			pstat.execute();
			pstat.close();
			System.out.println("CustomerDaoImpl .....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Customer selectCustomerByUsername(String username) {
		Customer customer = null;
		try {
			String sql="select name,password from ES_CUSTOMER"
					+ " where name=?";
			//String sql="select name,password from ES_CUSTOMER where name=?";
			PreparedStatement pstat = DBUtils.getPstat(sql);
			pstat.setString(1, username);
			
			ResultSet resultSet = pstat.executeQuery();
			while(resultSet.next()) {
				customer = new Customer();
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				customer.setUsername(name);
				customer.setPassword(password);
			}
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
