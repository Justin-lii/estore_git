package com.briup.bean;

/*
 * ��������ô��������ط���
 * 	1.�û�����鼮�����ﳵ
 * 		���ﳵ�����а���  key-value: �鼮id-������   ��Ϊ����ͬһ����ʱ��Ҫ�ϲ���Ϣ��
 * 	2.�û��¶�������
 */
public class OrderLine {
	//�������ţ������ݿ�������id��Ӧ�����ﳵ��ع��ܲ�����
	private Integer id;
	//�鼮����
	private int num;	
	//��Ӧ���鼮
	private Book book;
	//��Ӧ�Ķ���
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
