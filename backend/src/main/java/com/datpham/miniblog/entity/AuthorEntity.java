package com.datpham.miniblog.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "AUTHOR")
public class AuthorEntity {

    @Id
    @Column(name = "AUTHOR_ID", nullable = false)
    private String authorId;

    @Column(name = "AUTHOR_NAME", nullable = false)
    private String authorName;

    @Column(name = "AUTHOR_EMAIL", nullable = false)
    private String authorEmail;

    @Column(name = "AUTHOR_DESCRIPTION", nullable = false)
    private String authorDescription;

    @Column(name = "AUTHOR_AVATAR", nullable = false)
    private String authorAvatar;

    @Column(name = "AUTHOR_PHONE", nullable = false)
    private String authorPhone;

    @Column(name = "AUTHOR_DATE_OF_BIRTH", nullable = false)
    private LocalDate authorDateOfBirth;

    @Column(name = "AUTHOR_PASSWORD", nullable = false)
    private String authorPassword;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<BlogEntity> blogEntities;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<ContactEntity> contactEntities;

    @ManyToOne
    @JoinColumn(name = "ADMIN_ID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AdminEntity adminId;



}
