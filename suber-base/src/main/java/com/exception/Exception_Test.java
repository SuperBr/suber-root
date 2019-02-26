package com.exception;

/**
 * @author wangyongchao
 * @date 2019/2/25  11:30
 */
public class Exception_Test {

    public void method() {

        Throwable throwable = new Exception();


        /**
         * ArrayIndexOutOfBoundsException
         *
         * ClassCastException
         *
         * NullPointException
         */
        Throwable throwable1=new RuntimeException();


        /**
         *
         * StackOverflowError
         *
         * OOM
         */
        Throwable throwable2 = new Error();

        methodA();

        try {
            methodB();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

    }


    public void methodA() throws  RuntimeException {

    }

    public void methodB() throws  Exception {

    }
}
