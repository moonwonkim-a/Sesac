package com.ohgiraffers.section06.singleton;

public class LazySingleton {

    /* 일단 변수만 만들어두고, 처음에는 비워둔다(null) */
    private static LazySingleton lazy;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if(lazy == null) {
            lazy = new LazySingleton();
        }
        return lazy;
    }
}
