package com.ohgirafferas.jpql.section03.projection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> singleEntityProjection(){

        String jpql = "SELECT m FROM Section03Menu m";

        return entityManager.createQuery(jpql,Menu.class).getResultList();
    }

    public List<Object[]> scalarTypeProjection(){
        String jpql = "SELECT c.categoryCode, c.categoryName FROM Section03Category c";

        return entityManager.createQuery(jpql).getResultList();
    }

    public List<CategoryInfo> newCommandProjection(){   // 생성자로 생성
        String jpql = "SELECT new com.ohgirafferas.jpql.section03.projection.CategoryInfo(c.categoryCode, c.categoryName) "
                + "FROM Section03Category c";

        return entityManager.createQuery(jpql,CategoryInfo.class).getResultList();
    }

}
