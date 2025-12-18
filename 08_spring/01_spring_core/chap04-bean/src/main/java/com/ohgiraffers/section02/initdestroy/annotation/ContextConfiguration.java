package com.ohgiraffers.section02.initdestroy.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@ComponentScan("com.ohgiraffers.section02.initdestroy.annotation")
public class ContextConfiguration {

    @Bean
    public Product carpBread (){
        return new Bread("붕어빵", 1000, new Date());
    }

    @Bean
    public Product milk(){
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water(){
        return new Beverage("지리산 암반수", 3000, 500);
    }

    @Bean
    public ShoppingCart cart(){
        return new ShoppingCart();
    }


    @Bean(initMethod = "openShop", destroyMethod = "closeShop") // PostConstruct,PreDestroy 어노테이션을 사용하지 않고 같은 효과를 쓰는 방식
    public Owner owner(){
        return new Owner();
    }
}
