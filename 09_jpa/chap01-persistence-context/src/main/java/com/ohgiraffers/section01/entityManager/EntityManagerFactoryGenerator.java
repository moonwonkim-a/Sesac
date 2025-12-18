package com.ohgiraffers.section01.entityManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryGenerator {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpatest");

    private EntityManagerFactoryGenerator() {}

    public static EntityManagerFactory getInstance() {
        return factory;
    }
}
