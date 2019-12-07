package com.crystalark.jpa.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(scale = 5, name = "user_id")
    private long id;

    @Column(name = "u_name")
    private UserName name;

    @Column(name = "u_address")
    private UserAddress address;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @OneToOne(mappedBy = "user")
    private Order order;

    @ManyToMany(mappedBy = "user")
    private Set<Department> department;

    protected User() {}

    public User(UserName name, UserAddress address) {
        this.name = name;
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    public long getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public UserAddress getAddress() {
        return address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                '}';
    }
}