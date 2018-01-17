package com.mxd.anno;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.SqlBuilder;

public class SqlClass {
	/**
	 * �Ƽ���ʽ
	 * �°汾����ֱ�Ӵ���id������Ҫʹ��map����,�����°汾Ҳ��֧��map�ķ�ʽ
	 * �ô�������ʹ�ô������ķ�ʽƴ��sql���
	 */
	public String getSql(Integer id){
		SQL sql = new SQL();
		sql.SELECT("*").FROM("user");
		if(id!=null){
			sql.WHERE("id=#{id}");
		}
		
		return sql.toString();
	}
	
	//���ڷ�ʽ,mybatis�°汾����ʹ��
	/*public String getSql2(Map<String, Object> map){
		Integer id = (Integer) map.get("id");
		
		SqlBuilder.BEGIN();
		SqlBuilder.SELECT("*");
		SqlBuilder.FROM("user");
		if (id != null && !"".equals(id)) {
			SqlBuilder.WHERE("id=#{id}");
		}
		// ʹ��SQL()��������Sql��
		String sql = SqlBuilder.SQL();
		return sql;
		// return "select * from user where id = #{id}";
	}*/
	
	//�����ڲ��෽ʽ
	public String getSql3(Integer id/*Map<String, Object> map*/) {
		//final Integer id = (Integer) map.get("id");
		// �����ڲ��๹��
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
