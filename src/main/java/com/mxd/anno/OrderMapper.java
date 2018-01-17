package com.mxd.anno;

import org.apache.ibatis.annotations.Select;

import com.mxd.pojo.po.Order;

public interface OrderMapper {
	
	/**
	 * 遗留问题：这里的返回值为什么是Order不是List<Order>
	 */
	@Select(value={"select * from orders where uid=#{id}"})
	Order selectByFk(Integer id);
}
