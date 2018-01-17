package com.mxd.anno;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.SqlBuilder;

public class SqlClass {
	/**
	 * 推荐方式
	 * 新版本可以直接传入id，不需要使用map接收,并且新版本也不支持map的方式
	 * 好处：可以使用代码连的方式拼接sql语句
	 */
	public String getSql(Integer id){
		SQL sql = new SQL();
		sql.SELECT("*").FROM("user");
		if(id!=null){
			sql.WHERE("id=#{id}");
		}
		
		return sql.toString();
	}
	
	//过期方式,mybatis新版本不能使用
	/*public String getSql2(Map<String, Object> map){
		Integer id = (Integer) map.get("id");
		
		SqlBuilder.BEGIN();
		SqlBuilder.SELECT("*");
		SqlBuilder.FROM("user");
		if (id != null && !"".equals(id)) {
			SqlBuilder.WHERE("id=#{id}");
		}
		// 使用SQL()方法返回Sql串
		String sql = SqlBuilder.SQL();
		return sql;
		// return "select * from user where id = #{id}";
	}*/
	
	//匿名内部类方式
	public String getSql3(Integer id/*Map<String, Object> map*/) {
		//final Integer id = (Integer) map.get("id");
		// 匿名内部类构建
		SQL sql = new SQL() {{
				SELECT("*");
				FROM("user");
				if (id != null) {
					WHERE("id=#{id}");
				}
			}};
		return sql.toString();

	}
}
