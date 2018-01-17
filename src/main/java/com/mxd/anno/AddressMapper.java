package com.mxd.anno;

import org.apache.ibatis.annotations.Select;

import com.mxd.pojo.po.Address;

public interface AddressMapper {
	@Select(value={"select * from address where uid=#{id}"})
	Address selectByFk(Integer id);
}
