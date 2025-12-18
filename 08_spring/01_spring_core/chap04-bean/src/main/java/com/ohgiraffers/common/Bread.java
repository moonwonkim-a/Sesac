package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product{

    private java.util.Date bakedDate;   // 생산시간

    public Bread() {
        super();
    }

    public Bread(String name, int price , Date bakdeDate){
        super(name, price);
        this.bakedDate = bakdeDate;
    }

    public Date getBakedDate() {
        return bakedDate;
    }

    public void setBakedDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "bakedDate=" + bakedDate +
                '}';
    }
}
