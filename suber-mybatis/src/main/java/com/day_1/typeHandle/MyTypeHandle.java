package com.day_1.typeHandle;

import com.day_1.model.ex.PassWd;
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
public class MyTypeHandle extends BaseTypeHandler<PassWd> {

    public void setNonNullParameter(PreparedStatement ps, int i, PassWd parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getPassWd());
    }

    public PassWd getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return PassWd.defaultV;
    }

    public PassWd getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return PassWd.defaultV;
    }

    public PassWd getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return PassWd.defaultV;
    }
}
