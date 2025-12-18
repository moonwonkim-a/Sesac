package com.ohgirafferas.associationmapping.section03.bidirection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class BiDirectionServiceTests {

    @Autowired
    private BiDirectionService biDirectionService;

    @DisplayName("양방향 연관 관계 조회(연관관계 주인)")
    @Test
    void biDirectionFindTest1(){
        // given
        int menuCode = 10;
        // when
        Menu foundMenu = biDirectionService.findMenu(menuCode);
        // then
        assertEquals(menuCode,foundMenu.getMenuCode());
    }

    @DisplayName("양방향 연관 관계 조회(연관관계 주인 아님)")
    @Test
    void biDirectionFindTest2(){

        int categoryCode = 10;

        Category foundCategory = biDirectionService.findCategory(categoryCode);

        assertEquals(categoryCode,foundCategory.getCategoryCode());
    }
}
