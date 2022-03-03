package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MergeMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {

        Member member = createMember("memberA", "회원1");

        member.setUserName("회원명변경1");

        mergeMember(member);

    }

    public static Member createMember(String id, String userName){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Member member = null;

        try{

            tx.begin();

            member = new Member();
            member.setId(id);
            member.setUserName(userName);

            em.persist(member);

            tx.commit();
        }catch (Exception e){

            tx.rollback();
            e.printStackTrace();
        }finally {

            em.close();
        }

        return member;

    }

    public static void mergeMember(Member member){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Member mergeMember = null;

        try{
            tx.begin();

            mergeMember = em.merge(member);

            tx.commit();

            // 준영속 상태
            System.out.println("member = " + member.getUserName());

            // 준영속 상태인 것, 영속 상태인 것 확인
            System.out.println("em contains member = " + em.contains(member));
            System.out.println("em contains mergeMember = " + em.contains(mergeMember));

        }catch (Exception e){

            tx.rollback();
            e.printStackTrace();
        }finally {

            em.close();
        }

    }

}
