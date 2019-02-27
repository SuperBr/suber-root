package com;

import com.bean.Student;
import com.bean.Teacher;
import com.bean.api.IStudent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangyongchao
 * @date 2019/2/27  17:07
 */
public class MainApp {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        IStudent student = (IStudent) context.getBean("student");

        Teacher teacher = (Teacher) context.getBean("teacher");

        teacher.sayTeacher();

        student.sayHello();

        synchronized (context) {
            context.wait();
        }

    }

}
