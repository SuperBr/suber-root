package com.bean;

import com.bean.api.IStudent;
import org.springframework.stereotype.Service;

/**
 * @author wangyongchao
 * @date 2019/2/27  17:10
 */

@Service
public class Student implements IStudent {

    public void sayHello() {
        System.out.println("hello");
    }
}
