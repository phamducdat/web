package com.datpham.miniblog.service;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.ContactEntity;
import com.datpham.miniblog.mapper.ContactMapper;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.mock.ContactData;
import com.datpham.miniblog.repository.ContactRepository;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {

    @InjectMocks
    ContactService contactService;

    @Mock
    JavaMailSender javaMailSender;

    @Mock
    ContactRepository contactRepository;

    @Mock
    ContactMapper contactMapper;

    @Test
    public void createContact() {
        AuthorEntity authorEntity = AuthorData.mockAuthorEntity();
        ContactRequest contactRequest = ContactData.mockContactRequest();
        contactRequest.setAuthorId(authorEntity.getAuthorId());
        ContactEntity contactEntity = ContactData.mockContactEntity();
        contactEntity.setAuthorId(authorEntity);
        when(contactMapper.mapContactEntityFromContactRequest(contactRequest)).thenReturn(contactEntity);
        when(contactRepository.save(contactEntity)).thenReturn(contactEntity);
        contactService.createContact(contactRequest);
    }

    @Test
    public void getAllContact() {
        contactService.getAllContact();
    }

    @Test
    public void getContactListByAuthorId() {
        contactService.getAllContact();
    }
}
