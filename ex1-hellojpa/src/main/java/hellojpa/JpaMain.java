package hellojpa;

import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;

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
            Order order = new Order();
            em.persist(order);
//            order.addOrderItem(new OrderItem());

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            em.persist(orderItem);

            tx.commit();

            em.flush();
            em.clear();

            orderItem = em.find(OrderItem.class, orderItem.getId());
            System.out.println(orderItem.getOrder().getId());

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
