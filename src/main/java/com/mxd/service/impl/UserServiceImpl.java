package com.mxd.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;
import com.mxd.utils.DBUtil;

public class UserServiceImpl {
	// if��ǩwhere1=1
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

	// where��ǩ
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

	// where choose when otherwise��ǩ
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
	 * trim��ǩ ɾ��ָ���ַ������Բ���дwhere��ǩ
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

	// set��ǩ
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

	// foreach��ǩ
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
	
	// foreach��ǩ2
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
