package com.day_1.model.ex;

import com.day_1.model.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangyongchao
 * @date 2019/2/14  10:57
 */
public class LoginRecordDto implements Serializable {
    private Long id;

    private User user;

    private List<User> users;


    public List<User> getUsers() {
        return users;
    }

    public LoginRecordDto setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public Long getId() {
        return id;
    }

    public LoginRecordDto setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public LoginRecordDto setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "LoginRecordDto{" +
                "id=" + id +
                ", user=" + user +
                ", users=" + users +
                '}';
    }
}
