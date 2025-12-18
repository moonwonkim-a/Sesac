package om.ghgiraffers.section01.entitymanager;

import com.ohgiraffers.section01.entityManager.EntityManagerFactoryGenerator;
import com.ohgiraffers.section01.entityManager.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerFactoryGeneratorTests {

    @Test
    @DisplayName("엔티티 매니저 팩토리 생성 확인")
    void testGenerateEntityManagerFactory(){
        // given
        // when
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
        // then
        assertNotNull(factory);
    }

    @Test
    @DisplayName("엔티티 메니저 팩토리 싱글톤 인스턴스 확인")
    void testIsEntityManagerFactorySingletonInstance() {
        // given
        // when
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();

        //then
        assertEquals(factory1,factory2);
    }

    @Test
    @DisplayName("엔티티 메니저 생성 확인")
    void testGeneratorEntityManager(){
        //given
        //when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        assertNotNull(entityManager);
    }

    @Test
    @DisplayName("엔티티 메니저 스코프 확인")
    void testIsEntityManagerLifeCycle(){
        // given
        // when
        EntityManager entityManager1 = EntityManagerGenerator.getInstance();
        EntityManager entityManager2 = EntityManagerGenerator.getInstance();

        // then
        assertNotEquals(entityManager1,entityManager2);
    }
}
