package com.mxd.anno;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mxd.pojo.po.User;

public class TestAnno {
	UserService uService;
	@Before
	public void init(){
		uService = new UserService();
	}
	
	@Test
	public void TestSelectById(){
		User user = uService.selectById(2);
		System.out.println(user.getName()+"----"+user.getPassword());
	}
	
	@Test
	public void TestSelectSelect(){
		List<User> list = uService.selectBySelect();
		for(User user:list){
			System.out.println(user);
		}
	}
	
	@Test
	public void TestSelectJoin(){
		List<User> list = uService.selectByJoin();
		for(User user:list){
			System.out.println(user);
		}
	}
	
	@Test
	public void TestSqlClass(){
		User user = uService.selectBySqlClass(1);
		System.out.println(user.getName()+"----"+user.getPassword());
	}
}
