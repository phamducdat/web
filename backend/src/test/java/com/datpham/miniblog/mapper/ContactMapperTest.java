package com.datpham.miniblog.mapper;

import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.ContactEntity;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.mock.ContactData;
import com.datpham.miniblog.repository.AuthorRepository;
import com.datpham.miniblog.repository.ContactRepository;
import io.tej.SwaggerCodgen.model.Contact;
import io.tej.SwaggerCodgen.model.ContactList;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ContactMapperTest {

    @InjectMocks
    ContactMapper mapper;

    @Mock
    ContactRepository contactRepository;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    ContactEntity contactEntity;


    @Test
    public void ensureMapContactFromContactEntity() {
        AuthorEntity authorEntity = AuthorData.mockAuthorEntity();
        ContactEntity entity = ContactData.mockContactEntity();
        entity.setAuthorId(authorEntity);
//        when(contactEntity.getAuthorId()).thenReturn(authorEntity);
        Contact contact = mapper.mapContactFromContactEntity(entity);
        assertNotNull(contact.getContactId());
        assertEquals(entity.getContactMessage(), contact.getContactMessage());
        assertEquals(entity.getContactEmailFrom(), contact.getContactEmailFrom());
        assertEquals(entity.getContactName(), contact.getContactName());
        assertEquals(entity.getAuthorId().getAuthorId(), contact.getAuthorId());
    }

    @Test
    public void ensureMapContactEntityFromContactRequest() {
        ContactRequest request = ContactData.mockContactRequest();
        AuthorEntity author = AuthorData.mockAuthorEntity();
        request.setAuthorId(author.getAuthorId());
        when(authorRepository.getById(author.getAuthorId())).thenReturn(author);

        ContactEntity entity = mapper.mapContactEntityFromContactRequest(request);

        assertNotNull(entity.getContactId());
        assertEquals(request.getContactMessage(), entity.getContactMessage());
        assertEquals(request.getContactEmailFrom(), entity.getContactEmailFrom());
        assertEquals(request.getContactName(), entity.getContactName());
        assertEquals(request.getAuthorId(), entity.getAuthorId().getAuthorId());
    }

    private void assertContactList(List<ContactEntity> contactEntities, ContactList contactList) {
        assertContact(contactEntities.get(0), contactList.get(0));
    }


    private void assertContact(ContactEntity entity, Contact contact) {
        assertEquals(entity.getContactMessage(), contact.getContactMessage());
        assertEquals(entity.getContactId(), contact.getContactId());
        assertEquals(entity.getContactName(), contact.getContactName());
        assertEquals(entity.getContactEmailFrom(), contact.getContactEmailFrom());
    }

    @Test
    public void ensureMapContactListFromContactEntities() {
        AuthorEntity authorEntity = AuthorData.mockAuthorEntity();
        List<ContactEntity> contactEntities = ContactData.mockContactEntityList();
        contactEntities.forEach(contactEntity -> {
            contactEntity.setAuthorId(authorEntity);
        });

        ContactList contactList = mapper.mapContactListFromContactEntities(contactEntities);
        assertContactList(contactEntities, contactList);
    }

}
