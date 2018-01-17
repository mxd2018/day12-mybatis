package com.mxd.anno;

import org.apache.ibatis.annotations.Select;

import com.mxd.pojo.po.Order;

public interface OrderMapper {
	
	/**
	 * �������⣺����ķ���ֵΪʲô��Order����List<Order>
	 */
	@Select(value={"select * from orders where uid=#{id}"})
	Order selectByFk(Integer id);
}
