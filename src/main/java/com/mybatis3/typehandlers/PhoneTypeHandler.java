/**
 * 
 */
package com.mybatis3.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.mybatis3.domain.PhoneNumber;



public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber parameter, JdbcType jdbcType) throws SQLException {
		/**
		 * 注意：此处使用setString/getString是因为数据库中PhoneNumber字段是varchar类型
		 */
		ps.setString(i, parameter.getAsString());
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnName));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnIndex));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(cs.getString(columnIndex));
	}

	

}
