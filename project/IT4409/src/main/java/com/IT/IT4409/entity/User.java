package com.IT.IT4409.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //All
    @Column(name = "email")
    private String email;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "password")
    private String password;

    //For Employee
    @Column(name = "phone")
    private String phone;

    @Column(name = "skills")
    private String skills;

    @Column(name = "country")
    private String country;

    @Column(name = "education")
    private String education;

    @Column(name = "rates")
    private String rates;

    @Column(name = "company")
    private String company;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

    @Column(name = "gender")
    private Integer gender;

    //For Boss
//    @Column(name = "skillneed")
//    private String skillYouNeed;

//    @Column(name = "scopework")
//    private String scopeWork;

//    @Column(name = "hours")
//    private Integer hours;

//    @Column(name = "budget")
//    private Integer budget;

    @Column(name = "review")
    private String review;

    @ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name="user_role",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public void TestGit(){
        
    }
}
