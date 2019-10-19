package com.briup.service.impl;

import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.dao.CustomerDao;
import com.briup.dao.impl.CustomerDaoImpl;
import com.briup.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	private CustomerDao customerDao=new CustomerDaoImpl();
	//�����ݲ������ݿ�
	@Override
	public void insertCustomer(Customer customer) throws Exception {
		System.out.println("开始注册新用户");
		//检测该用户是否已经存在
		Customer isCustomer = customerDao.selectCustomerByUsername(customer.getUsername());
		if(isCustomer!=null) {
			System.out.println("该用户已经存在，请重新注册");
			throw new Exception("该用户已经存在，请重新注册");
		}
		if("".equals(customer.getUsername())) {
			throw new Exception("请输入用户名");
		}
		if("".equals(customer.getPassword())) {
			throw new Exception("请输入密码");
		}
		if("".equals(customer.getPhone())) {
			throw new Exception("请输入联系方式");
		}
		customerDao.insertCustomer(customer);
		System.out.println("CustomerServiceImpl :" +"注册成功");
	}

	@Override
	public Customer selectCustomerByUsername(Customer customer) throws Exception {
		Customer customer2 = customerDao.selectCustomerByUsername(customer.getUsername());
		if(customer2!=null) {
			if(customer2.getPassword().equals(customer.getPassword())) {
				System.out.println("登录成功");
			}else {
				System.out.println("密码错误");
				throw new Exception("密码错误，请重新输入");
			}
		}else {
			System.out.println("该用户不存在，请重新输入");
			throw new Exception("该用户不存在，请重新输入");
		}
		return customer2;
	}

}
