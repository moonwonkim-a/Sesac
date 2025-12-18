package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;


    /* 1. 특정 메뉴 코드로 메뉴 조회 */
    public Menu findMenuByMenuCode(int menuCode){

        entityManager = EntityManagerGenerator.getInstance();

        return entityManager.find(Menu.class, menuCode);    // Menu라는 Entity 타입에서 menuCode(primary key) 찾아와라.
    }

    /* 1. 새로운 메뉴 저장하는 기능 */
    public Long saveAndReturnAllCount(Menu newMenu){

        entityManager = EntityManagerGenerator.getInstance();

        EntityTransaction entityTransaction = entityManager.getTransaction();   // 트랜젝션 생성

        entityTransaction.begin();  // 엔티티 트랜젝션 시작.

        entityManager.persist(newMenu);

        entityTransaction.commit(); // 엔티티 트랜젝션 커밋

        return getCount(entityManager);
    }

    /* 메뉴 개수 조회하는 기능 */
    private Long getCount(EntityManager entityManager) {
        // JPQL 문법
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }

    /* 메뉴 이름 수정하는 기능 */
    public Menu modifyMenuName(int menuCode, String menuName){

        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class,menuCode);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        foundMenu.setMenuName(menuName);

        transaction.commit();

        return foundMenu;
    }

    /* 특정 메뉴 코드로 메뉴 삭제하는 기능 */
    public Long removeAndReturnAllCont(int menuCode){

        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class,menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.remove(foundMenu);

        entityTransaction.commit();

        return getCount(entityManager);
    }
}
