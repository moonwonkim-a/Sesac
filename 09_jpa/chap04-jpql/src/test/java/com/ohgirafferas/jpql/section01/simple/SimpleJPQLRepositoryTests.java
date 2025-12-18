package com.ohgirafferas.jpql.section01.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SimpleJPQLRepositoryTests {

    @Autowired
    private SimpleJPQLRepository simpleJPQLRepository;

    @DisplayName("TypedQuery를 이용한 단일행, 단일컬럼 조회")
    @Test
    void testSelectSingleMenuByTypedQuery(){

        String menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();

        assertEquals("한우딸기국밥",menuName);
    }

    @DisplayName("TypedQuery를 이용한 다중행 조회")
    @Test
    void testSelectMultirowTypedQuery(){

        List<Menu> menuList = simpleJPQLRepository.selectMultirowByTypedQuery();

        System.out.println("menuList : " + menuList);
        assertNotNull(menuList);
    }

    @DisplayName("Distinct를 이용한 다중행 조회")
    @Test
    void testSelectDistinct (){

        List<Integer> categoryList = simpleJPQLRepository.selectUsingDistinct();

        System.out.println("categoryList : " + categoryList);
        assertNotNull(categoryList);
    }

    @DisplayName("In연산자를 이용한 목록 조회")
    @Test
    void testSelectUsingIn(){

        List<Menu> menuList = simpleJPQLRepository.selectUsingIn();

        System.out.println("menuList : " + menuList);
        assertNotNull(menuList);
    }

    @DisplayName("Like연산자를 이용한 목록 조회")
    @Test
    void testSelectUsingLike(){

        List<Menu> menuList = simpleJPQLRepository.selectUsingLike();

        System.out.println("menuList : " + menuList);
        assertNotNull(menuList);
    }
}
