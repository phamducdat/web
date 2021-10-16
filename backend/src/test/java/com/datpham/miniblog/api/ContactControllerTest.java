package com.datpham.miniblog.api;

import com.datpham.miniblog.controller.ContactController;
import com.datpham.miniblog.mock.ContactData;
import com.datpham.miniblog.service.ContactService;
import com.datpham.miniblog.validator.AuthorValidator;
import com.datpham.miniblog.validator.ContactValidator;
import io.tej.SwaggerCodgen.model.Contact;
import io.tej.SwaggerCodgen.model.ContactList;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {

    @InjectMocks
    ContactController controller;

    @Mock
    ContactService contactService;

    @Mock
    ContactValidator contactValidator;

    @Mock
    AuthorValidator authorValidator;




    private void assertStatus200(HttpStatus actualStatus) {
        assertEquals(HttpStatus.OK, actualStatus);
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

    @Test
    public void testEndpointCreateContact() {

        ContactRequest request = ContactData.mockContactRequest();
        ResponseEntity<Void> responseEntity =
                controller.createContact(request    );

        assertStatus200(responseEntity.getStatusCode());

    }

    @Test
    public void  testEndpointGetAllContact() {
        ContactList contactList = ContactData.mockContactList();

        when(contactService.getAllContact()).thenReturn(contactList);
        ResponseEntity<ContactList> contactListResponseEntity =
                controller.getAllContact();

        assertStatus200(contactListResponseEntity.getStatusCode());
        assertContactList(contactListResponseEntity.getBody());
    }
}
