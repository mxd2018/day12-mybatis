package com.mxd.anno;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.mxd.pojo.po.User;

/**
 * 注意：
 * 1.使用缓存，pojo最好序列化实现Serializable接口
 * 	   因为当数据过大，缓存中无法放下时，对象数据会使用流被读写
 * 
 * 2.虽然此处使用的是注解的方式，但是mybatis.xml文件中还是要在<mappers>中配置
 * 	<package name="com.mxd.anno"/>，虽然没有了xml文件但是它要通过扫描接口映射
 */
@CacheNamespace(size=500)
public interface UserMapper {
	@Select(value={"select * from user where id=#{id}"})
	@Results(value={
			@Result(id=true,column="ID",property="id"),
			@Result(column="NAME",property="name"),
			@Result(column="PASSWORD",property="password")
			})
	@Options(flushCache=false,useCache=true,timeout=2000)
	User selectById(@Param(value="id") Integer ddd);
	
	/**
	 * 注意：此处使用的是select的关联查询，select属性后的链接除了包名还要加上接口名和方法名称
	 * 
	 * 遗留问题：这里address的name值好像没打印出来是null，需要再检查
	 * 
	 */
	@Select(value={"select * from user"})
	@Results(value={
			@Result(id=true,column="ID",property="id"),
			@Result(column="NAME",property="name"),
			@Result(column="PASSWORD",property="password"),
			@Result(column="ID",property="addr",one=@One(select="com.mxd.anno.AddressMapper.selectByFk")),
			@Result(column="ID",property="orders",many=@Many(select="com.mxd.anno.OrderMapper.selectByFk"))
			})
	List<User> selectBySelect();
	
	/**
	 * 注意：
	 * 1.要想使用join方式的链接查询仍旧需要写xml文件，来配置关联关系
	 * 2.除了xml文件，还要使用@ResultMap注解，其中的value值就是xml文件中配置的id
	 * 3.XML文件中如果两张表的字段名重复记得起别名（本案例中没起）
	 * 4.XML文件中<ResultMap>标签中有个javaType属性别忘记设置
	 */
	@Select(value={"select * from user left join address on user.id = address.uid"})
	@ResultMap(value="baseResultMap")
	List<User> selectByJoin();
	
	/**
	 * 注意：
	 * 1.该方式是把过复杂的sql语句写在一个Java类中，通过type属性引用下
	 * 
	 */
	@SelectProvider(type=SqlClass.class,method="getSql3")
	User selectBySqlClass(Integer id);
	
}
