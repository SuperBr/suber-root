package com.enumt;

import org.junit.Test;
import sun.security.jca.GetInstance;

public class enum_Test {


    public enum Single {

        INSTENCE;

        void getInstance() {

        }
    }

    @Test
    public void enum_Test() {
        Single.INSTENCE.getInstance();

    }
}
