package hellojpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "items")
    private List<Category> categoryList = new ArrayList<>();
}

