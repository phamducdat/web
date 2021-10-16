package com.datpham.miniblog.validator;
import com.datpham.miniblog.exception.BadRequestException;
import com.datpham.miniblog.exception.EntityNotFoundException;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.mock.ContactData;
import com.datpham.miniblog.repository.ContactRepository;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import java.net.ConnectException;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ContactValidatorTest {

    @InjectMocks
    ContactValidator validator;

    @Mock
    ContactRepository repository;

    @Rule
    public ExpectedException exception  = ExpectedException.none();

    @Test
    public void validateAddContact() {
        ContactRequest contactRequest = ContactData.mockContactRequest();
        contactRequest.setAuthorId(AuthorData.AUTHOR_ID);
        validator.validateAddContact(contactRequest);
    }

    @Test
    public void validateContactExit() {
        exception.expect(EntityNotFoundException.class);
        exception.expectMessage("Contact does not exist");

        when(repository.existsById(ContactData.CONTACT_ID)).thenReturn(false);

        validator.validateContactExist(ContactData.CONTACT_ID);
    }

    @Test
    public void validateContactShowExceptionWhenWrongAuthorId() {
        exception.expect(BadRequestException.class);
        exception.expectMessage("authorid is required");
        validator.validateAddContact(ContactData.mockContactRequest());
    }
}
