package com.ohgiraffers.section02.initdestroy.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();

        for(String beans : beanNames){
            System.out.println(beans);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water",Beverage.class);

        ShoppingCart cart1 = context.getBean("cart",ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println(cart1.getItems());

        ShoppingCart cart2 = context.getBean("cart",ShoppingCart.class);
        cart2.addItem(water);

        System.out.println(cart2.getItems());

        /* destroy 메소드는 빈 객체 소멸 시점에 동작하므로 컨테이너가 종료 되어야 확인 가능하다. */
        ((AnnotationConfigApplicationContext)context).close();

    }
}
