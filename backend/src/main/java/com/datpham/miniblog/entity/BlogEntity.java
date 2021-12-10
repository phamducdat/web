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

    @Column(name = "BLOG_INTRODUCTION")
    private String blogIntroduction;

    @Column(name = "BLOG_CONTENT")
    private String blogContent;

    @Column(name = "BLOG_PICTURE")
    private String blogPicture;


    @Column(name = "BLOG_DATE", nullable = false)
    private LocalDate blogDate;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AuthorEntity authorId;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CategoryEntity categoryId;

    @Column(name = "CATEGORY_NAME", nullable = true)
    private String categoryName;


}
