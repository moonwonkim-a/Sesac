package com.ohgirafferas.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Member member) {   // Entity(member)를 저장하는 메소드
        entityManager.persist(member);
    }

    public String findNameById(String memberId){

        // table명이 아닌 entity명이 들어가있음
        // 별칭을 꼭 붙혀서 사용해야함. m -> entityMember
        String jpql = "SELECT m.memberName FROM entityMember m WHERE m.memberId = '" + memberId + "'";

        return entityManager.createQuery(jpql,String.class).getSingleResult();
    }
}