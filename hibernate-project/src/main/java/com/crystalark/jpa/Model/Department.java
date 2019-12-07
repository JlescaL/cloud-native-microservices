package com.crystalark.jpa.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {
    @Id
    @Column(name="dept_id")
    @GeneratedValue
    private String id;
    private String name;

    @ManyToMany
    @JoinTable(name = "department_map",
            joinColumns = @JoinColumn(name = "dept_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> user;

    protected Department(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<User> getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}