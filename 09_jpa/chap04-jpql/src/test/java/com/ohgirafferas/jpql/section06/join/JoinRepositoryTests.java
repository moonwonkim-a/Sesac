package com.ohgirafferas.jpql.section06.join;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JoinRepositoryTests {

    @Autowired
    private JoinRepository joinRepository;

    @DisplayName("내부조인을 이용한 조회 테스트")
    @Test
    public void testSelectByInnerJoin() {
        List<Menu> menuList = joinRepository.selectByInnerJoin();

        assertNotNull(menuList);
    }

    @DisplayName("외부 조인 테스트")
    @Test
    void testSelectByOuterJoin(){
        List<Object[]> menuList = joinRepository.selectByOuterJoin();
        assertNotNull(menuList);
        menuList.forEach(
                row -> {
                    for(Object colum : row){
                        System.out.println(colum + " ");
                    }
                    System.out.println();
                }
        );
    }

    @DisplayName("패치 조인 테스트")
    @Test
    void testSelectByFetchJoin() {

        List<Menu> menuList = joinRepository.selectByFetchJoin();
        assertNotNull(menuList);
    }

}
