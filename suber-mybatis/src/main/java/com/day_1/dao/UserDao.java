package com.day_1.dao;

import com.day_1.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wangyongchao
 * @date 2019/2/13  15:45
 */
public interface UserDao {


    void insert(User user);

    List<User> selectAll();

    @Select("select * from user where id=#{id}")
    User selectBtId(@Param("id") Long id);
}
