package com.ohgiraffers.section02.initdestroy.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component
public class Owner {

//    @PostConstruct    // initMethod와 같은 역할
    public void openShop(){
        System.out.println("==Shop Open==");
    }

//    @PreDestroy   // destroyMethod와 같은 역할
    public void closeShop() {

        System.out.println("--Shop Closed--");
    }
}
