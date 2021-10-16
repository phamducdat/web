package com.datpham.miniblog.validator;


import com.datpham.miniblog.exception.BadRequestException;
import com.datpham.miniblog.exception.EntityNotFoundException;
import com.datpham.miniblog.repository.ContactRepository;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactValidator {

    public static final String CONTACT_DOES_NOT_EXIST = "Contact does not exist";

    private final ContactRepository repository;

    @Autowired
    public ContactValidator(ContactRepository repository) {
        this.repository = repository;
    }

    public void validateContactExist(String id) {
        if (repository.existsById(id)) return;
        throw new EntityNotFoundException(CONTACT_DOES_NOT_EXIST);
    }

    public void validateAddContact(ContactRequest request) {
        checkRequiredField(request.getAuthorId(), "authorId");
        checkRequiredField(request.getContactEmailFrom(), "ContactEmailFrom");
        checkRequiredField(request.getContactName(), "ContactName");
        checkRequiredField(request.getContactMessage(), "ContactMessage");
    }

    private void checkRequiredField(String value, String errorMsg) {
        if (null == value || value.trim().isEmpty())
            throw new BadRequestException(errorMsg.toLowerCase() + " is required");
    }
}
