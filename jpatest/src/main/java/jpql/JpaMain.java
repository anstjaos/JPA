package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            for (int i = 0; i < 15; i++) {
                Member member = new Member();
                member.setUserName("member" + i);
                member.setAge(i);
                member.setType(MemberType.ADMIN);
                em.persist(member);
            }

            List<Member> query = em.createQuery("select m from Member m where m.type = jpql.MemberType.ADMIN", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(10)
                    .getResultList();

            query.forEach(m -> System.out.println("member = " + m));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
