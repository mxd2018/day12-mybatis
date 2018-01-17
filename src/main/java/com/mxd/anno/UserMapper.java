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
 * ע�⣺
 * 1.ʹ�û��棬pojo������л�ʵ��Serializable�ӿ�
 * 	   ��Ϊ�����ݹ��󣬻������޷�����ʱ���������ݻ�ʹ��������д
 * 
 * 2.��Ȼ�˴�ʹ�õ���ע��ķ�ʽ������mybatis.xml�ļ��л���Ҫ��<mappers>������
 * 	<package name="com.mxd.anno"/>����Ȼû����xml�ļ�������Ҫͨ��ɨ��ӿ�ӳ��
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
	 * ע�⣺�˴�ʹ�õ���select�Ĺ�����ѯ��select���Ժ�����ӳ��˰�����Ҫ���Ͻӿ����ͷ�������
	 * 
	 * �������⣺����address��nameֵ����û��ӡ������null����Ҫ�ټ��
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
	 * ע�⣺
	 * 1.Ҫ��ʹ��join��ʽ�����Ӳ�ѯ�Ծ���Ҫдxml�ļ��������ù�����ϵ
	 * 2.����xml�ļ�����Ҫʹ��@ResultMapע�⣬���е�valueֵ����xml�ļ������õ�id
	 * 3.XML�ļ���������ű���ֶ����ظ��ǵ����������������û��
	 * 4.XML�ļ���<ResultMap>��ǩ���и�javaType���Ա���������
	 */
	@Select(value={"select * from user left join address on user.id = address.uid"})
	@ResultMap(value="baseResultMap")
	List<User> selectByJoin();
	
	/**
	 * ע�⣺
	 * 1.�÷�ʽ�ǰѹ����ӵ�sql���д��һ��Java���У�ͨ��type����������
	 * 
	 */
	@SelectProvider(type=SqlClass.class,method="getSql3")
	User selectBySqlClass(Integer id);
	
}
