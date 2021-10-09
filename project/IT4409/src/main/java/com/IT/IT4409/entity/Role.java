package com.IT.IT4409.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="role_id")
    private int id;

    @Column(name="role")
    private String role;

    @ManyToMany(cascade = CascadeType.MERGE,
            mappedBy = "roles")
    private Set<User> users;

    public Role(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role() {}

}