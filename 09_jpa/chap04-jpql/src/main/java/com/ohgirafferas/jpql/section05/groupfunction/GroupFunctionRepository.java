package com.ohgirafferas.jpql.section05.groupfunction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupFunctionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long countMenuOfCategory(int categoryCode){
        String jpql = "SELECT COUNT(m.menuCode) FROM Section05Menu m WHERE m.categoryCode = :categoryCode";

        long countOfMenu = entityManager.createQuery(jpql,Long.class)
                .setParameter("categoryCode",categoryCode)
                .getSingleResult();

        return countOfMenu;
    }
    /* COUNT 외 다른 그룹함수는 결과 값이 없을 경우 NULL을 반환하기 때문에 기본 자료형으로 다룰 경우 문제가 발생
    * Long과 같이 Wrapper 클래스 자료형으로 사용 해야 한다. */
    public Long otherWithNoResult(int categoryCode){    // SUM, MAX같은 그룹함수들은 값이 없다면 NULL로 반환됨.
        String jpql = "SELECT SUM(m.menuPrice) FROM Section05Menu m WHERE m.categoryCode = :categoryCode";

        Long sumOfMenu = entityManager.createQuery(jpql,Long.class)
                .setParameter("categoryCode",categoryCode)
                .getSingleResult();

        return sumOfMenu;
    }

    public List<Object[]> selectByGroupByHaving(long minPrice){
        String jpql = "SELECT m.categoryCode, SUM(m.menuPrice) FROM Section05Menu m"
                + " GROUP BY m.categoryCode HAVING SUM(m.menuPrice) >= : minPrice";

        List<Object[]> sumPriceOfCategoryList = entityManager.createQuery(jpql)
                .setParameter("minPrice",minPrice).getResultList();

        return sumPriceOfCategoryList;
    }

}
