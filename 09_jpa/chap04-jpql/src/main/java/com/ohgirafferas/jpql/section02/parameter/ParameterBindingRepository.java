package com.ohgirafferas.jpql.section02.parameter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParameterBindingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectMenuByBindingName(String menuName){

        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = :menuName";
        List<Menu> resulMenuList = entityManager.createQuery(jpql,Menu.class)
                        .setParameter("menuName",menuName)  // ("쿼리문안에 있는 :parameter", parameter)
                        .getResultList();
        return resulMenuList;
    }

    public List<Menu> selectMenuByBindingPosition(String menuName){

        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = ?1";
        List<Menu> resultMenuList = entityManager.createQuery(jpql,Menu.class)
                .setParameter(1,menuName)   // ("쿼리문 안에 ?숫자, parameter)
                .getResultList();

        return resultMenuList;
    }

}
