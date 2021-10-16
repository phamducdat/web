package com.datpham.miniblog.controller;

import com.datpham.miniblog.service.ContactService;
import com.datpham.miniblog.validator.AuthorValidator;
import com.datpham.miniblog.validator.ContactValidator;
import io.tej.SwaggerCodgen.api.ContactsApi;
import io.tej.SwaggerCodgen.model.ContactList;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/miniblogs/backend/v1")
public class ContactController implements ContactsApi {

    private final ContactService contactService;
    private final ContactValidator contactValidator;
    private final AuthorValidator authorValidator;

    @Autowired
    public ContactController(ContactService contactService, ContactValidator contactValidator, AuthorValidator authorValidator) {
        this.contactService = contactService;
        this.contactValidator = contactValidator;
        this.authorValidator = authorValidator;
    }

    @Override
    public ResponseEntity<Void> createContact(ContactRequest contactRequest) {
        contactValidator.validateAddContact(contactRequest);
        authorValidator.validateAuthorExist(contactRequest.getAuthorId());
        contactService.createContact(contactRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContactList> getAllContact() {
        ContactList contactList = contactService.getAllContact();

        return new ResponseEntity<>(contactList,HttpStatus.OK);
    }
}
