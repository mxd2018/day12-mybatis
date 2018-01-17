package com.mxd.anno;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mxd.pojo.po.User;
import com.mxd.utils.DBUtil;

public class UserService {
	
	public User selectById(Integer id){
		SqlSession session = DBUtil.getSession();
		User user = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			user = mapper.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}
	
	public List<User> selectBySelect(){
		SqlSession session = DBUtil.getSession();
		List<User> list =null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.selectBySelect();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	public List<User> selectByJoin(){
		SqlSession session = DBUtil.getSession();
		List<User> list =null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.selectByJoin();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	public User selectBySqlClass(Integer id){
		SqlSession session = DBUtil.getSession();
		User user = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			user = mapper.selectBySqlClass(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}
}
