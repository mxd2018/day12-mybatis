package com.mxd.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.mxd.pojo.po.User;

public interface IUserDao {
	List<User> selectByItem(User user);
	
	List<User> selectByItem2(User user);
	
	List<User> selectByItem3(User user);
	
	List<User> selectByItem4(User user);
	
	void setByItem(User user);
	
	List<User> selectByArray(Integer[] arr);
	
	List<User> selectByArray2(User user);
}
