package com.datpham.miniblog.service;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.mapper.AuthorMapper;
import com.datpham.miniblog.repository.AuthorRepository;
import io.tej.SwaggerCodgen.model.Author;
import io.tej.SwaggerCodgen.model.AuthorList;
import io.tej.SwaggerCodgen.model.AuthorLogin;
import io.tej.SwaggerCodgen.model.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper ) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public Author createAuthor(AuthorRequest request) {
        AuthorEntity entity = authorRepository.save(authorMapper.mapAuthorEntityFromAuthorRequest(request));
        return authorMapper.mapAuthorFromAuthorEntity(entity);
    }

    public AuthorList getAllAuthor() {
        return authorMapper.mapAuthorListFroAuthorEntities(authorRepository.findAll());
    }

    public Author getAuthorById(String authorId) {
        AuthorEntity entity = authorRepository.getById(authorId);

        return authorMapper.mapAuthorFromAuthorEntity(entity);
    }

    public Author loginAuthor(AuthorLogin authorLogin) {
        List<AuthorEntity> authorEntityList = authorRepository.findAll();

        for (AuthorEntity authorEntity : authorEntityList) {
            if (authorLogin.getAuthorEmail().equals(authorEntity.getAuthorEmail())) {
                if (bCryptPasswordEncoder.matches(authorLogin.getAuthorPassword(), authorEntity.getAuthorPassword())) {
                    return authorMapper.mapAuthorFromAuthorEntity(authorEntity);
                }
            }
        }
        return null;
    }
}
