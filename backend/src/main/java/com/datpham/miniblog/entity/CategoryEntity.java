package com.datpham.miniblog.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @Column(name = "CATEGORY_ID", nullable = false)
    private String categoryId;

    @Column(name = "CATEGORY_NAME", nullable = false)
    private String categoryName;

    @Column(name="CATEGORY_TYPE", nullable = false)
    private String categoryType;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<BlogEntity> blogEntities;
}
