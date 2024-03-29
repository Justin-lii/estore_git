package com.briup.bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/*
 * 订单类
 */
public class Order {
	private Integer id;
	private double total;	//总金额
	private Date orderDate;	//订单日期
	private Customer customer; 	//顾客
	
	//收货人姓名
	private String name;
	//收货人电话
	private String telephone;
	//收货人地址
	private String address;
	//订单中包含的 全部订单项
	private Collection<OrderLine> lines;
	
	public Order() {}
	
	public Order(Integer id, double total, Date orderDate) {
		super();
		this.id = id;
		this.total = total;
		this.orderDate = orderDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTotal() {
		double total = 0;
		for(OrderLine line : lines) {
			total += line.getBook().getPrice()*line.getNum();
		}
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<OrderLine> getLines() {
		return lines;
	}

	public void setLines(Collection<OrderLine> collection) {
		this.lines = collection;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", total=" + total + ", orderDate=" + orderDate + ", customer=" + customer
				+ ", name=" + name + ", telephone=" + telephone + ", address=" + address + "]";
	}
	
	
}
