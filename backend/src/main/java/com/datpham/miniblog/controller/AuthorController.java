package com.datpham.miniblog.controller;


import com.datpham.miniblog.service.AuthorService;
import com.datpham.miniblog.service.BlogService;
import com.datpham.miniblog.service.ContactService;
import com.datpham.miniblog.validator.AuthorValidator;
import io.tej.SwaggerCodgen.api.AuthorsApi;
import io.tej.SwaggerCodgen.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/miniblogs/backend/v1")
public class AuthorController implements AuthorsApi {

    private final AuthorService authorService;
    private final BlogService blogService;
    private final ContactService contactService;
    private final AuthorValidator authorValidator;


    @Autowired
    public AuthorController(AuthorService authorService, BlogService blogService, ContactService contactService, AuthorValidator authorValidator) {
        this.authorService = authorService;
        this.blogService = blogService;
        this.contactService = contactService;
        this.authorValidator = authorValidator;
    }

    @Override
    public ResponseEntity<Author> createAuthor(AuthorRequest authorRequest) {
        authorValidator.validateAddAuthor(authorRequest);
        Author author = authorService.createAuthor(authorRequest);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AuthorList> getAllAuthor() {
        AuthorList authorList = authorService.getAllAuthor();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BlogList> getAllBlogByAuthor(String authorId) {
        authorValidator.validateAuthorExist(authorId);
        BlogList blogList = blogService.getAllBlogByAuthorId(authorId);

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContactList> getAllContactByAuthor(String authorId) {
        authorValidator.validateAuthorExist(authorId);
        ContactList contactList = contactService.getContactListByAuthorId(authorId);

        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Author> getAuthorById(String authorId) {
        authorValidator.validateAuthorExist(authorId);
        Author author = authorService.getAuthorById(authorId);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
