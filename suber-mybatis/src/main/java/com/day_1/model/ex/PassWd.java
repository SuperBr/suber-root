package com.day_1.model.ex;

/**
 * @author wangyongchao
 * @date 2019/2/13  18:43
 */
public class PassWd {

    public static final PassWd defaultV=new PassWd().setPassWd("****");


    private String passWd;

    public String getPassWd() {
        return passWd;
    }

    public PassWd(String passWd) {
        this.passWd = passWd;
    }

    public PassWd() {
    }

    public PassWd setPassWd(String passWd) {
        this.passWd = passWd;
        return this;
    }

    @Override
    public String toString() {
        return "PassWd{" +
                "passWd='" + passWd + '\'' +
                '}';
    }
}
