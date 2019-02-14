package com.day_1.model;

import com.annotation.SQL;
import com.day_1.model.ex.PassWd;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author wangyongchao
 * @date 2019/2/13  15:37
 */

@SQL("create table user( id int8 auto_increment ,passwd varchar(64) , name varchar(64) ,age int4 ,birthDay timestamp ,deleted BIT ,flag int2  ,primary key (id) );")
public class User {

    private Long id;

    private PassWd passWd;

    private String name;

    private Integer age;

    private Date birthDay;

    private Boolean deleted;

    private Short flag;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public PassWd getPassWd() {
        return passWd;
    }

    public User setPassWd(PassWd passWd) {
        this.passWd = passWd;
        return this;
    }

    public User setPassWd(String passWd) {
        this.passWd = new PassWd(passWd);
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public User setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public User setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public Short getFlag() {
        return flag;
    }

    public User setFlag(Short flag) {
        this.flag = flag;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", passWd=" + passWd +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", deleted=" + deleted +
                ", flag=" + flag +
                '}';
    }
}
