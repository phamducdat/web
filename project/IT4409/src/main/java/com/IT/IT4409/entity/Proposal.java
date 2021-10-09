package com.IT.IT4409.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "proposals")
@Getter
@Setter
public class Proposal {

    // Cần chữa lại cho phép cột "id" của bảng "proposals" thực hiện được AUTO_INCREMENT
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "timeRequirement")
    private String timeRequirement;

    // Is accepted
    @Column(name = "status")
    private boolean status = false;

    @Column(name = "job_post_id")
    private long jobPostId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "freelancer_id", referencedColumnName = "id")
    private User freelancer;
}
