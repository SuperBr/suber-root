package com.day_1;

import com.day_1.dao.UserDao;
import com.day_1.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Random;

/**
 * @author wangyongchao
 * @date 2019/2/13  14:59
 */
public class Day_1_main {

    public static void main(String[] args) throws IOException {

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("day_1/mybatis-config.xml"));


        SqlSession session = sqlSessionFactory.openSession();
        UserDao mapper = session.getMapper(UserDao.class);

        User user = new User();
        user.setPasswd(Integer.valueOf(new Random().nextInt(100000)).toString());

        mapper.insert(user);

        System.out.println(mapper.selectAll());


        System.out.println(mapper.selectBtId(5L));

        session.commit();

    }

}
