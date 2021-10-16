package com.datpham.miniblog.mock;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.ContactEntity;
import io.tej.SwaggerCodgen.model.Contact;
import io.tej.SwaggerCodgen.model.ContactList;
import io.tej.SwaggerCodgen.model.ContactRequest;

import java.util.Collections;
import java.util.List;

public class ContactData {

    public static final String CONTACT_ID = "225";
    public static final String CONTACT_NAME = "contact";
    public static final String CONTACT_EMAIL_FROM = "test@gmail.com";
    public static final String CONTACT_MESSAGE = "test";
    public static final AuthorEntity AUTHOR_ENTITY = new AuthorEntity();
    public static Contact mockContact() {
        Contact contact = new Contact();
        contact.setContactId(CONTACT_ID);
        contact.setContactName(CONTACT_NAME);
        contact.setContactMessage(CONTACT_MESSAGE);
        contact.setContactEmailFrom(CONTACT_EMAIL_FROM);
        return  contact;
    }

    public static ContactRequest mockContactRequest() {
        ContactRequest request = new ContactRequest();
        request.setContactName(CONTACT_NAME);
        request.setContactMessage(CONTACT_MESSAGE);
        request.setContactEmailFrom(CONTACT_EMAIL_FROM);
        return  request;
    }

    public static ContactEntity mockContactEntity() {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(CONTACT_ID);
        contactEntity.setContactName(CONTACT_NAME);
        contactEntity.setContactMessage(CONTACT_MESSAGE);
        contactEntity.setContactEmailFrom(CONTACT_EMAIL_FROM);
        return contactEntity;
    }

    public static ContactList mockContactList() {
        ContactList list = new ContactList();
        list.add(mockContact());
        return list;
    }

    public static List<ContactEntity> mockContactEntityList() {
        return Collections.singletonList(mockContactEntity());
    }
}
