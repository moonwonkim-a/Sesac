package com.ohgirafferas.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectByInnerJoin(){

        String jpql = "SELECT m FROM Section06Menu m JOIN m.category c";

        List<Menu> menuList = entityManager.createQuery(jpql,Menu.class).getResultList();

        return menuList;
    }

    public List<Object[]> selectByOuterJoin(){

        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Menu m RIGHT JOIN m.category c"
                + " ORDER BY m.category.categoryCode";

        List<Object[]> menuList = entityManager.createQuery(jpql).getResultList();

        return menuList;
    }

    public List<Menu> selectByFetchJoin(){
        // FETCH : JOIN 뒤에 붙혀주고 즉시 로딩을 실행
        String jpql = "SELECT m FROM Section06Menu m JOIN FETCH m.category c";

        List<Menu> menuList = entityManager.createQuery(jpql,Menu.class).getResultList();

        return menuList;
    }
}
