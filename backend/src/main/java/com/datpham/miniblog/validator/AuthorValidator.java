package com.datpham.miniblog.validator;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.exception.BadRequestException;
import com.datpham.miniblog.exception.EntityConflictException;
import com.datpham.miniblog.exception.EntityNotFoundException;
import com.datpham.miniblog.repository.AuthorRepository;
import io.tej.SwaggerCodgen.model.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorValidator {

    private static final String AUTHOR_DOES_NOT_EXIST = "Author does not exist";
    private static final String AUTHOR_EXIST = "Author exist, please try to other email";

    private final AuthorRepository repository;


    @Autowired
    public AuthorValidator(AuthorRepository repository) {
        this.repository = repository;
    }

    public void validateAddAuthor(AuthorRequest request) {
        checkRequiredField(request.getAuthorEmail(),errorMsg("email"));
        checkRequiredField(request.getAuthorName(),errorMsg("name"));
    }

    private void checkRequiredField(String value, String errorMsg) {
        if (null == value || value.trim().isEmpty())
            throw new BadRequestException(errorMsg);
    }

    private String errorMsg(String value) {
        return value.toLowerCase() + " is requested";
    }
    public void validateAuthorExist(String id) {
        if (repository.existsById(id)) return;
        throw new EntityNotFoundException(AUTHOR_DOES_NOT_EXIST);
    }
    public void validateAuthorEmailNotExist(String authorEmail) {
        List<AuthorEntity> authorEntityList = repository.findAll();
        for (AuthorEntity authorEntity: authorEntityList) {
            if (authorEmail.equals(authorEntity.getAuthorEmail()))
                throw new EntityConflictException(AUTHOR_EXIST);
        }

    }
}
