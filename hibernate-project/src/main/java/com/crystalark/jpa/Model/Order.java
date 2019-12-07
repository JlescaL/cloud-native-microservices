package com.crystalark.jpa.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToOne()
    @JoinColumn(name = "user_idss", referencedColumnName = "user_id") //Creates a new column named user_idss in Order table referencing user_d of User Table
    //@MapsId //Creates a new column named user_user_id in Order table referencing user_d of User Table
    private User user;

    public Order(Date createdAt) {
        this.createdAt = createdAt;
    }

    protected Order(){}

    public long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}