package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            /* 삽입
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);
            */
            /* 수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
            */
            /*
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
                    for (Member member : result) {
                        System.out.println("member.name = " + member.getName());
                    }
            */
            Member member = new Member(100L, "zzzz");
            em.persist(member);
            em.flush();

            System.out.println("======================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
