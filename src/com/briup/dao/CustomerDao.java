package com.briup.dao;

import com.briup.bean.Customer;

public interface CustomerDao {

	//ע�����û�
	public void insertCustomer(Customer customer);
	
	//�����û�����ѯ�û�
	public Customer selectCustomerByUsername(String username);
}
