package com.datpham.miniblog.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "ADMIN")
public class AdminEntity {

    @Id
    @Column(name = "ADMIN_ID", nullable = false)
    private String adminId;

    @Column(name = "ADMIN_NAME", nullable = false)
    private String adminName;

    @Column(name = "ADMIN_EMAIL", nullable = false)
    private String adminEmail;

    @Column(name = "ADMIN_PASSWORD", nullable = false)
    private String adminPassword;

}
