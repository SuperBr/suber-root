package com.day_1.typeHandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wangyongchao
 * @date 2019/2/13  18:09
 */
public class MyTypeHandle extends BaseTypeHandler<String> {

    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter+":new");
    }

    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return "********";
    }

    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return "********";
    }

    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return "********";
    }
}
