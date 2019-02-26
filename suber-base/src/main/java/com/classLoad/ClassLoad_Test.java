package com.classLoad;

import org.junit.Test;

public class ClassLoad_Test {


    @Test
    public void class_Test() {
        ClassA b = new ClassB();


    }


    static class ClassA {

        private static int a;

        private static int b = 0;

        {
            System.out.println("代码块--a-1");
        }

        static {
            System.out.println("static代码块--a-1");
        }

        public ClassA() {
            System.out.println("构造方法a");
        }

        static {
            System.out.println("static代码块--a-2");
        }


        {
            System.out.println("代码块--a-2");
        }

    }

    static class ClassB extends ClassA {
        {
            System.out.println("代码块--b-1");
        }

        static {
            System.out.println("static代码块--b-1");
        }

        public ClassB() {
            System.out.println("构造方法b");
        }

        static {
            System.out.println("static代码块--b-2");
        }


        {
            System.out.println("代码块--b-2");
        }

    }

    @Test
    public void classc_Test() {
        ClassC classC = ClassC.getClassC();


    }

    static class ClassC {

        private static int a;

        private static int b = 2;

        static ClassC classC = new ClassC();

        public ClassC() {
            System.out.println("a" + a);
            System.out.println("b" + b);
        }

        public static ClassC getClassC() {
            return classC;
        }
    }
}
