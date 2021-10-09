package com.IT.IT4409.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

//@DynamicUpdate
@Entity
@Table(name = "jobPost")
@Getter
@Setter
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "expertiseLevel")
    private String expertiseLevel;

    @Column(name = "skill")
    private String skill;

    @Column(name = "timeRequirement")
    private String timeRequirement;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "createdTime")
    @CreationTimestamp
    private Timestamp createdTime;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

}
