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

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<BlogEntity> blogEntities;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<ContactEntity> contactEntities;



}
