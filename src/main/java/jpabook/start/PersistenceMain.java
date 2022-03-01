package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceMain {

    public static void main(String[] args) {

        testDetached();


    }

    public static void testDetached(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Member member = new Member();
            member.setId("memberA");
            member.setUserName("회원A");

            em.persist(member);

            em.detach(member);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

        emf.close();

    }

    public static void testClear(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try{

            transaction.begin();

            Member member = em.find(Member.class, "memberA");

            em.clear();

            member.setUserName("changeName");

            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

        emf.close();

    }

    public static void closeEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Member memberA = em.find(Member.class, "memberA");
        Member memberB = em.find(Member.class, "memberB");

        transaction.commit();

        em.close();

        emf.close();

    }

}
