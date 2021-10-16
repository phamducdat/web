package com.datpham.miniblog.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "CONTACT")
@AllArgsConstructor
@NoArgsConstructor
public class ContactEntity {

    @Id
    @Column(name = "CONTACT_ID", nullable = false)
    private String contactId;

    @Column(name = "CONTACT_NAME", nullable = false)
    private String contactName;

    @Column(name = "CONTACT_EMAIL_FROM", nullable = false)
    private String contactEmailFrom;

    @Column(name = "CONTACT_MESSAGE", nullable = false)
    private String contactMessage;




    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AuthorEntity authorId;
}
