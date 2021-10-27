package com.datpham.miniblog.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany(mappedBy = "adminId", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<AuthorEntity> authorEntities;

}
