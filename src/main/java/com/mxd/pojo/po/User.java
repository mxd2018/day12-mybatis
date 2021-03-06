package com.mxd.pojo.po;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class User implements Serializable{
	private Integer id;
	private String name;
	private String password;
	/*private Integer[] ids;*/
	private Address addr;
	private List<Order> orders;
 	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", addr=" + addr + ", orders=" + orders
				+ "]";
	}
	
	
	
	/*public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", ids=" + Arrays.toString(ids) + "]";
	}*/
	
	
	
	

}
