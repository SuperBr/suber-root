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

    public LoginRecordDto(Long id) {
        this.id = id;
    }

    public LoginRecordDto() {
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
