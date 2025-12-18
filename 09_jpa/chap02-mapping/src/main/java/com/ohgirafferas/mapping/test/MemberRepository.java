package com.ohgirafferas.mapping.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public MemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save (Member member){
        entityManager.persist(member);
    }

    public String findEmail (int memberNum) {

        Member member = entityManager.find(Member.class,memberNum);

        return member.getEmail();
    }

    public String findId (int memberNum) {

        Member member = entityManager.find(Member.class,memberNum);

        return member.getId();
    }

}
