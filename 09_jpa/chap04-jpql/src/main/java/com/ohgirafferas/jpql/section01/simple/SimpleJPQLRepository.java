package com.ohgirafferas.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public String selectSingleMenuByTypedQuery(){

        String jpql = "SELECT m.menuName FROM Section01Menu m WHERE m.menuCode = 8";

        TypedQuery<String> query = entityManager.createQuery(jpql,String.class);    // (jpql문자열, 반환 타입.class)

        String resultMenuName = query.getSingleResult();

        return resultMenuName;
    }

    public List<Menu> selectMultirowByTypedQuery(){

        String jpql = "SELECT m FROM Section01Menu m ";

        TypedQuery<Menu> query = entityManager.createQuery(jpql,Menu.class);    // (jpql문자열, 반환 타입.class)

        List<Menu> resultMenuList = query.getResultList();  // 여러개의 행을 반환

        return resultMenuList;
    }

    public List<Integer> selectUsingDistinct(){

        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu m";

        TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);

        List<Integer> resultCategoryList = query.getResultList();

        // List<Integer> resultCategoryList = entityManager.createQuery(jpql,Integer.class).getResultList();
        // 이런식으로 줄여서 구현 가능

        return resultCategoryList;
    }

    /* 11, 12 카테고리 코드를 가진 메뉴 목록 조회 */
    public List<Menu> selectUsingIn() {

        String jpql = "SELECT m FROM Section01Menu m WHERE m.categoryCode IN (11, 12)";

        List<Menu> query = entityManager.createQuery(jpql,Menu.class).getResultList();  // 이런식으로 줄여서 사용 가능

        return query;
    }

    /* "마늘" 이라는 문자열이 메뉴명에 포함되는 메뉴 목록 조회 */
    public List<Menu> selectUsingLike() {

        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuName LIKE '%마늘%'";

        List<Menu> query = entityManager.createQuery(jpql,Menu.class).getResultList();

        return query;
    }
}
