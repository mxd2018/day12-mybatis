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
		user.setName("����");
		//user.setPassword("1234");
		List<User> list = userServiceImpl.selectByItem(user);
		System.out.println(list);
	}
	@Test
	public void TestSelectByItem2(){
		User user=new User();
		//user.setName("����");
		//user.setPassword("1234");
		List<User> list = userServiceImpl.selectByItem2(user);
		System.out.println(list);
	}
	@Test
	public void TestSelectByItem3(){
		User user=new User();
		user.setName("����");
		user.setPassword("1234");
		List<User> list = userServiceImpl.selectByItem3(user);
		System.out.println(list);
	}
	
	@Test
	public void TestSelectByItem4(){
		User user=new User();
		//user.setName("����");
		user.setPassword("1234");
		List<User> list = userServiceImpl.selectByItem4(user);
		System.out.println(list);
	}
	@Test
	/**
	 * ע�⣺
	 * 1.ʲôҲ���޸Ļᱨ�쳣��û��update user�����
	 * 2.�ô�����ֻ�޸�һ���ֶ�ʱ�������ֶλ���ԭ�������ݣ������Ϊnull
	 */
	public void TestSetByItem(){
		User user=new User();
		user.setId(1);
		user.setName("set��ǩ�޸ĵ�����");
		//user.setPassword("11111");
		userServiceImpl.setByItem(user);
	}
	
	@Test
	public void TestSelectByArray(){
		/*����Ķ�̬��ʼ��
		Integer[] arr2 = new Integer[3];*/

		//����ľ�̬��ʼ��
		//Integer[] arr = {1,2,3};
		Integer[] arr3 = new Integer[]{1,2,3};
		
		List<User> list = userServiceImpl.selectByArray(arr3);
		System.out.println(list);
	}
	
	@Test
	//foreach��ǩͨ�������������������
	public void TestSelectByArray2(){
		
		User user = new User();
		Integer[] arr = {1,2,3};
		user.setIds(arr);
		
		List<User> list = userServiceImpl.selectByArray2(user);
		System.out.println(list);
	}
	
	
}
