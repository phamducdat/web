package com.datpham.miniblog.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "BLOG")
@NoArgsConstructor
public class BlogEntity {

    @Id
    @Column(name = "BLOG_ID", nullable = false)
    private String blogId;

    @Column(name = "BLOG_NAME", nullable = false)
    private String blogName;

    @Column(name = "BLOG_INTRODUCTION", nullable = false)
    private String blogIntroduction;

    @Column(name = "BLOG_CONTENT", nullable = false)
    private String blogContent;

    @Column(name = "BLOG_PICTURE", nullable = false)
    private String blogPicture;

    @Column(name = "BLOG_TYPE", nullable = false)
    private String blogType;

    @Column(name = "BLOG_DATE", nullable = false)
    private Date blogDate;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AuthorEntity authorId;

    public BlogEntity(String blogId, String blogName, String blogIntroduction, String blogContent, String blogPicture, String blogType, Date blogDate, AuthorEntity authorId) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.blogIntroduction = blogIntroduction;
        this.blogContent = blogContent;
        this.blogPicture = blogPicture;
        this.blogType = blogType;
        this.blogDate = blogDate;
        this.authorId = authorId;
    }

}
