package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }

    public static void logic(EntityManager em){

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUserName("kim");
        member.setAge(3);

        // 등록
        em.persist(member);

        // 수정
        member.setAge(20);

        // 한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUserName() + ", age=" + findMember.getAge());

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        System.out.println("memberListSize=" + members.size());

        // 삭제
        em.remove(member);

    }
}
