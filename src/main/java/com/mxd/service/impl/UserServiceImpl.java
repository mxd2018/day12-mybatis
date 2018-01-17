package com.mxd.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;
import com.mxd.utils.DBUtil;

public class UserServiceImpl {
	// if标签where1=1
	public List<User> selectByItem(User user) {
		SqlSession session = DBUtil.getSession();
		List<User> list = null;
		try {
			IUserDao mapper = session.getMapper(IUserDao.class);
			list = mapper.selectByItem(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	// where标签
	public List<User> selectByItem2(User user) {
		SqlSession session = DBUtil.getSession();
		List<User> list = null;
		try {
			IUserDao mapper = session.getMapper(IUserDao.class);
			list = mapper.selectByItem2(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	// where choose when otherwise标签
	public List<User> selectByItem3(User user) {
		SqlSession session = DBUtil.getSession();
		List<User> list = null;
		try {
			IUserDao mapper = session.getMapper(IUserDao.class);
			list = mapper.selectByItem3(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * trim标签 删除指定字符，可以不用写where标签
	 */
	public List<User> selectByItem4(User user) {
		SqlSession session = DBUtil.getSession();
		List<User> list = null;
		try {
			IUserDao mapper = session.getMapper(IUserDao.class);
			list = mapper.selectByItem4(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	// set标签
	public void setByItem(User user) {
		SqlSession session = DBUtil.getSession();
		try {
			IUserDao mapper = session.getMapper(IUserDao.class);
			mapper.setByItem(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// foreach标签
	public List<User> selectByArray(Integer[] arr) {
		SqlSession session = DBUtil.getSession();
		List<User> list = null;
		try {
			IUserDao mapper = session.getMapper(IUserDao.class);
			list = mapper.selectByArray(arr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	// foreach标签2
		public List<User> selectByArray2(User user) {
			SqlSession session = DBUtil.getSession();
			List<User> list = null;
			try {
				IUserDao mapper = session.getMapper(IUserDao.class);
				list = mapper.selectByArray2(user);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return list;
		}
}
