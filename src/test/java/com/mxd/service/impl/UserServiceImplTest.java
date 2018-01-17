package com.mxd.service.impl;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mxd.pojo.po.User;
import com.mysql.fabric.xmlrpc.base.Array;


public class UserServiceImplTest {
	UserServiceImpl userServiceImpl;
	
	@Before
	public void init(){
		userServiceImpl=new UserServiceImpl();
	}
	@Test
	public void TestSelectByItem(){
		User user=new User();
		user.setName("李四");
		//user.setPassword("1234");
		List<User> list = userServiceImpl.selectByItem(user);
		System.out.println(list);
	}
	@Test
	public void TestSelectByItem2(){
		User user=new User();
		//user.setName("李四");
		//user.setPassword("1234");
		List<User> list = userServiceImpl.selectByItem2(user);
		System.out.println(list);
	}
	@Test
	public void TestSelectByItem3(){
		User user=new User();
		user.setName("李四");
		user.setPassword("1234");
		List<User> list = userServiceImpl.selectByItem3(user);
		System.out.println(list);
	}
	
	@Test
	public void TestSelectByItem4(){
		User user=new User();
		//user.setName("李四");
		user.setPassword("1234");
		List<User> list = userServiceImpl.selectByItem4(user);
		System.out.println(list);
	}
	@Test
	/**
	 * 注意：
	 * 1.什么也不修改会报异常，没有update user的语句
	 * 2.好处：当只修改一个字段时，其它字段还是原来的数据，不会变为null
	 */
	public void TestSetByItem(){
		User user=new User();
		user.setId(1);
		user.setName("set标签修改的张三");
		//user.setPassword("11111");
		userServiceImpl.setByItem(user);
	}
	
	@Test
	public void TestSelectByArray(){
		/*数组的动态初始化
		Integer[] arr2 = new Integer[3];*/

		//数组的静态初始化
		//Integer[] arr = {1,2,3};
		Integer[] arr3 = new Integer[]{1,2,3};
		
		List<User> list = userServiceImpl.selectByArray(arr3);
		System.out.println(list);
	}
	
	@Test
	//foreach标签通过对象来传递数组参数
	public void TestSelectByArray2(){
		
		User user = new User();
		Integer[] arr = {1,2,3};
		user.setIds(arr);
		
		List<User> list = userServiceImpl.selectByArray2(user);
		System.out.println(list);
	}
	
	
}
