package com.briup.bean;

/*
 * 订单项的用处有两个地方：
 * 	1.用户添加书籍到购物车
 * 		购物车对象中包含  key-value: 书籍id-订单项   因为购买同一本书时需要合并信息。
 * 	2.用户下订单结算
 */
public class OrderLine {
	//订单项编号，与数据库中主键id对应，购物车相关功能不关心
	private Integer id;
	//书籍数量
	private int num;	
	//对应的书籍
	private Book book;
	//对应的订单
	private Order order;
	
	public OrderLine() {}
	public OrderLine(int num) {
		this.num = num;
	}
	public OrderLine(Integer id, int num) {
		this.id = id;
		this.num = num;
	}
	public OrderLine(Integer id, int num, Book book) {
		this.id = id;
		this.num = num;
		this.book = book;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", book=" + book + "]";
	}
	
}
