package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> items;  // 쇼핑카트에 담긴 상품들

    // 생성자가 호출될 때 ArrayList가 만들어 질 수 있도록 해줌
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product item){
        items.add(item);
    }

    public List<Product> getItems (){
        return items;
    }
}
