package com.datpham.miniblog.api;


import com.datpham.miniblog.controller.AuthorController;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.mock.BlogData;
import com.datpham.miniblog.mock.ContactData;
import com.datpham.miniblog.service.AuthorService;
import com.datpham.miniblog.service.AuthorServiceTest;
import com.datpham.miniblog.service.BlogService;
import com.datpham.miniblog.service.ContactService;
import com.datpham.miniblog.validator.AuthorValidator;
import io.tej.SwaggerCodgen.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {

    @InjectMocks
    AuthorController controller;

    @Mock
    AuthorService authorService;

    @Mock
    ContactService contactService;

    @Mock
    AuthorValidator authorValidator;

    @Mock
    BlogService blogService;

    private void assertStatus200(HttpStatus actualStatus) {
        assertEquals(HttpStatus.OK, actualStatus);
    }

    private void assertAuthor(Author actual) {
        assertEquals(AuthorData.AUTHOR_ID, actual.getAuthorId());
        assertEquals(AuthorData.AUTHOR_NAME, actual.getAuthorName());
        assertEquals(AuthorData.AUTHOR_EMAIL, actual.getAuthorEmail());
        assertEquals(AuthorData.AUTHOR_DESCRIPTION, actual.getAuthorDescription());
        assertEquals(AuthorData.AUTHOR_AVATAR, actual.getAuthorAvatar());
    }

    private void assertBlog(Blog actual) {
        assertEquals(BlogData.BLOG_ID, actual.getBlogId());
        assertEquals(BlogData.BLOG_CONTENT, actual.getBlogContent());
        assertEquals(BlogData.BLOG_NAME, actual.getBlogName());
        assertEquals(BlogData.BLOG_CONTENT, actual.getBlogContent());
        assertEquals(BlogData.BLOG_TYPE, actual.getBlogType());
        assertEquals(BlogData.BLOG_PICTURE, actual.getBlogPicture());
        assertEquals(BlogData.BLOG_INTRODUCTION, actual.getBlogIntroduction());
    }

    private void assertContact(Contact actual) {
        assertEquals(ContactData.CONTACT_MESSAGE, actual.getContactMessage());
        assertEquals(ContactData.CONTACT_ID, actual.getContactId());
        assertEquals(ContactData.CONTACT_NAME, actual.getContactName());
        assertEquals(ContactData.CONTACT_EMAIL_FROM, actual.getContactEmailFrom());
    }
    private void assertContactList(ContactList actual) {
        assertContact(actual.get(0));
    }
    private void assertBlogList(BlogList blogList) {
        assertBlog(blogList.get(0));
    }

    @Test
    public void testEndpointCreateAuthor() {

        AuthorRequest request = AuthorData.mockAuthorRequest();


        when(authorService.createAuthor(request))
                .thenReturn(AuthorData.mockAuthor());
        ResponseEntity<Author> responseEntity =
                controller.createAuthor(request);
        assertStatus200(responseEntity.getStatusCode());
        assertAuthor(Objects.requireNonNull(responseEntity.getBody()));
    }


    @Test
    public void testEndpointGetAllAuthor() {
        AuthorList authorList = AuthorData.mockAuthorList();

        when(authorService.getAllAuthor()).thenReturn(authorList);

        ResponseEntity<AuthorList> responseEntity =
                controller.getAllAuthor();
        assertStatus200(responseEntity.getStatusCode());
        assertAuthorList(responseEntity.getBody());
    }

    private void assertAuthorList(AuthorList authorList) {
        assertAuthor(authorList.get(0));
    }
    @Test
    public void testEndpointGetAllBlogByAuthor() {

        BlogList blogList = BlogData.mockBlogList();

        when(blogService.getAllBlogByAuthorId(AuthorData.AUTHOR_ID)).thenReturn(blogList);

        ResponseEntity<BlogList> responseEntity =
                controller.getAllBlogByAuthor(AuthorData.AUTHOR_ID);

        assertBlogList(responseEntity.getBody());
        assertStatus200(responseEntity.getStatusCode());


    }

    @Test
    public void testEndpointGetAllContactByAuthor() {
        ContactList contactList = ContactData.mockContactList();

        when(contactService.getContactListByAuthorId(AuthorData.AUTHOR_ID)).thenReturn(contactList);

        ResponseEntity<ContactList> contactListResponseEntity =
                controller.getAllContactByAuthor(AuthorData.AUTHOR_ID);

        assertStatus200(contactListResponseEntity.getStatusCode());
        assertContactList(contactListResponseEntity.getBody());
    }

    @Test
    public void testEndpointGetAuthorById() {
        Author author = AuthorData.mockAuthor();
        when(authorService.getAuthorById(AuthorData.AUTHOR_ID)).thenReturn(author);

        ResponseEntity<Author> authorResponseEntity =
                controller.getAuthorById(AuthorData.AUTHOR_ID);

        assertAuthor(authorResponseEntity.getBody());
        assertStatus200(authorResponseEntity.getStatusCode());
    }

}
