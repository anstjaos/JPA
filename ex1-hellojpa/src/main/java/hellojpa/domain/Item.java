package hellojpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long itemId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Integer price;
}
