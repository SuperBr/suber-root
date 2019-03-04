package com.jackSon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyongchao
 * @date 2019/3/4  17:12
 */
public class JackSon_Test {

    private final static ObjectMapper objMap = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public static void main(String[] args){

        Map<Student, Teacher> studentTeacherMap = new HashMap<>();
        studentTeacherMap.put(new Student(), new Teacher());
        studentTeacherMap.put(new Student(), new Teacher());
        System.out.println(map2Json(studentTeacherMap));

    }

    public static String map2Json(Map map) {
        try {
            return    objMap.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  static class Student{

        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public Student setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public Student setAge(Integer age) {
            this.age = age;
            return this;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    public static class Teacher {
        private String name;

        private Integer age;


        public String getName() {
            return name;
        }

        public Teacher setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public Teacher setAge(Integer age) {
            this.age = age;
            return this;
        }
    }
}
