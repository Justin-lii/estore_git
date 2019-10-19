package com.briup.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ���ﳵ��
 * 	���ԣ� map���ϣ���Ϊ������ţ�ֵΪ������
 * 	����������鼮 �� ���ﳵ
 * 		��ȡ���еĶ�����
 */
public class ShopCar {
	//һ�����ﳵ ������� ������
	//���䣺����Ϊ��Ա������ȷ��ÿ����ӵĶ�������ӵ�ͬһ�����ﳵ��
	//			Integer�����bookId��Ŀ�ģ�����ظ������һ���飬�����ڹ��ﳵ��ԭ�е������� +1
	private Map<Integer, OrderLine> car = new HashMap<>();
	
	//���鼮������ ��װ�õ�һ����������� ��ӵ����ﳵ
	public void addCar(Book book,int num) {
		//�鿴���ﳵ���Ƿ� �Ѿ����ڸö��������鼮
		int bookId = book.getId();
		OrderLine line2 = car.get(bookId);
		//������ﳵ����δ��Ӹ��鼮�����½��������ӵ�����
		if(line2 == null) {
			OrderLine line = new OrderLine();
			line.setBook(book);
			line.setNum(num);
			
			//�����һ�ι�����鼮��ֱ����ӵ����ﳵ
			car.put(bookId, line);
		}else {
			//������ﳵ���Ѿ����˸��鼮���� �޸Ĺ��ﳵ���鼮��������
			line2.setNum(num+line2.getNum());
		}
	}
	
	//��չ��ﳵ
	public void clear() {
		car.clear();
	}
	
	//��ȡ���ж�����
	public Collection<OrderLine> getLines() {
		return car.values();
	}
	
	//��ȡ ������ ����
	public int getCount() {
		return car.values().size();
	}
	
	//��ȡ���ﳵ���ܽ��
	public double getTotal() {
		double total = 0;
		for (Integer id : car.keySet()) {
			OrderLine line = car.get(id);
			total += line.getNum()*line.getBook().getPrice();
		}
		return total;
	}

	//�����鼮idɾ�� ������
	public void remove(int id) {
		car.remove(id);
	}
	
	//�޸Ĺ��ﳵָ������������
	public void change(int bookId,int num) {
		OrderLine line = car.get(bookId);
		if(line != null)
			line.setNum(num);
	}
	
}
