package com.IT.IT4409.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "contracts")
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="jobPostId")
    private long jobPostId;

    @Column(name = "bossId")
    private long bossId;

    @Column(name = "freelancerId")
    private long freelancerId;

    @Column(name = "isActive")
    private boolean isAcive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id")
    private Proposal proposal;

    @Column(name = "createdAt")
    @CreationTimestamp
    private Timestamp createdTime;
}
