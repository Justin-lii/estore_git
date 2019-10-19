package com.briup.service;

import com.briup.bean.Customer;

public interface ICustomerService {

	public void insertCustomer(Customer customer) throws Exception;
	
	public Customer selectCustomerByUsername(Customer customer) throws Exception;
}
