package com.datpham.miniblog.service;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.mapper.AuthorMapper;
import com.datpham.miniblog.repository.AuthorRepository;
import io.tej.SwaggerCodgen.model.Author;
import io.tej.SwaggerCodgen.model.AuthorList;
import io.tej.SwaggerCodgen.model.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
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
}
