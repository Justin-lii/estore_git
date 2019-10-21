package com.briup.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;

import com.briup.bean.Category;
import com.briup.bean.Customer;
import com.briup.dao.CategoryDao;
import com.briup.util.DBUtils;

public class CategoryDaoImpl implements CategoryDao{
	@Override
	public Map<Category,List<Category>> findAllCategories() {
		List<Category> list = new ArrayList<Category>();
		Map<Category,List<Category>> map = new HashMap<>();
		Category category = null;
		try {
			//String sql="select * from es_category where category_id is null";
			String sql="select c1.id,c1.name name,c1.description description,c1.category_id,c2.name allname,c2.description alldesc\r\n" + 
					"from es_category c1 left join es_category c2\r\n" + 
					"on  c1.category_id =c2.id";
			//String sql="select name,password from ES_CUSTOMER where name=?";
			PreparedStatement pstat = DBUtils.getPstat(sql);
			
			ResultSet resultSet = pstat.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String info = resultSet.getString("description");
				int category_id = resultSet.getInt("category_id");
				category = new Category(id, name, info, category_id);
				list.add(category);
			}
			for(int i = 0; i<list.size();i++) {
				if(list.get(i).getCategory_id()==0) {
					List<Category> list2 = new ArrayList<>();
					for(int j = 0; j<list.size();j++) {
						if(list.get(j).getCategory_id()!=0 && 
								list.get(j).getCategory_id()==list.get(i).getId()) {
							list2.add(list.get(j));
						}
					}
					map.put(list.get(i), list2);
				}
			}
			// 遍历map第一种方法
			Set<Category> ks = map.keySet();
			for(Object key:ks) {
				Object value = map.get(key);
				System.out.println(key);
				System.out.println("\t"+value);
			}
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Category> findAllCategoryWithBooks() {
		return null;
	}

	@Override
	public Category findCategoryWithBooksById(int id) {
		return null;
	}
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
