package hellojpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CITY")
    private String city;

    @OneToOne(mappedBy = "delivery")
    private Order order;
}
