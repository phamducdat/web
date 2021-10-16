package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.ContactEntity;
import com.datpham.miniblog.repository.AuthorRepository;
import com.datpham.miniblog.repository.ContactRepository;
import io.tej.SwaggerCodgen.model.Contact;
import io.tej.SwaggerCodgen.model.ContactList;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactMapper {

    private final ContactRepository repository;
    private final AuthorRepository authorRepository;


    @Autowired
    public ContactMapper(ContactRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }


    public Contact mapContactFromContactEntity(ContactEntity from) {
        Contact contact = new Contact();
        contact.setContactId(from.getContactId());
        contact.setContactName(from.getContactName());
        contact.setContactMessage(from.getContactMessage());
        contact.setContactEmailFrom(from.getContactEmailFrom());
        contact.setAuthorId(from.getAuthorId().getAuthorId());

        return  contact;
    }


    public ContactEntity mapContactEntityFromContactRequest(ContactRequest request) {
        ContactEntity entity = new ContactEntity();
        AuthorEntity author = authorRepository.getById(request.getAuthorId());
        entity.setContactId(UUID.randomUUID().toString());
        entity.setContactMessage(request.getContactMessage());
        entity.setContactEmailFrom(request.getContactEmailFrom());
        entity.setAuthorId(author);
        entity.setContactName(request.getContactName());
        return entity;


    }

    public ContactList mapContactListFromContactEntities(List<ContactEntity> from) {
        ContactList contactList = new ContactList();

        from.forEach(contactEntity -> {
            contactList.add(mapContactFromContactEntity(contactEntity));
        });

        return contactList;
    }


}
