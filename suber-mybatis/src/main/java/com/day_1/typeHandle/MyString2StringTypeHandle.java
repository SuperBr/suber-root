package com.day_1.typeHandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wangyongchao
 * @date 2019/2/14  9:53
 */
public class MyString2StringTypeHandle extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter+":");
    }
    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        rs.getString(columnName);
        return "123*****";
    }
    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        rs.getString(columnIndex);
        return "123*****";
    }
    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        cs.getString(columnIndex);
        return "123*****";
    }
}
