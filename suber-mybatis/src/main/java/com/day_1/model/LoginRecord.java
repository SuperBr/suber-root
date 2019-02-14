package com.day_1.model;

import com.annotation.SQL;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangyongchao
 * @date 2019/2/14  10:52
 */
@SQL("create table login_record(id int8 not null auto_increment,user_id int8 not null,login_date timestamp,primary key(id))")
public class LoginRecord implements Serializable {

    private Long id;

    private Long  userId;

    private Date loginDate;


    public Long getId() {
        return id;
    }

    public LoginRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public LoginRecord setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public LoginRecord setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
        return this;
    }
}
