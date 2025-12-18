package com.ohgirafferas.jpql.section05.groupfunction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GroupFunctionRepositoryTests {

    @Autowired
    private GroupFunctionRepository groupFunctionRepository;

    @DisplayName("특정 카테고리에 등록 된 메뉴 수 조회")
    @Test
    void testCountMenuOfCategory(){

        int categoryCode = 5;

        long countOfMenu = groupFunctionRepository.countMenuOfCategory(categoryCode);

        assertTrue(countOfMenu >= 0);
        System.out.println("countOfMenu = " + countOfMenu);
    }

    @DisplayName("COUNT외 다른 그룹함수 조회 결과가 없는 경우")
    @Test
    void testSumMenuOfCategory(){

        int categoryCode = 1245;

        assertDoesNotThrow(
                ()->{
                    Long sumOfMenu = groupFunctionRepository.otherWithNoResult(categoryCode);
                    System.out.println("sumOfMenu = " + sumOfMenu);
                }
        );

    }

    @DisplayName("HAVING절 조회 테스트")
    @Test
    void testSelectByHaving(){

//        int minPrice = 50000; // 이거도 가능
        Long minPrice = 50000L;

        List<Object[]> sumPriceOfCategoryList = groupFunctionRepository.selectByGroupByHaving(minPrice);

        assertNotNull(sumPriceOfCategoryList);
    }
}
