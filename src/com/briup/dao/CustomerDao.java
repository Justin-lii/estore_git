package com.briup.dao;

import com.briup.bean.Customer;

public interface CustomerDao {

	//注册新用户
	public void insertCustomer(Customer customer);
	
	//根据用户名查询用户
	public Customer selectCustomerByUsername(String username);
}
