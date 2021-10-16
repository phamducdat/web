package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.repository.AuthorRepository;
import io.tej.SwaggerCodgen.model.Author;
import io.tej.SwaggerCodgen.model.AuthorList;
import io.tej.SwaggerCodgen.model.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorMapper {

    private final AuthorRepository repository;


    @Autowired
    public AuthorMapper(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author mapAuthorFromAuthorEntity(AuthorEntity from) {
        Author author = new Author();
        author.setAuthorId(from.getAuthorId());
        author.setAuthorAvatar(from.getAuthorAvatar());
        author.setAuthorEmail(from.getAuthorEmail());
        author.setAuthorDescription(from.getAuthorDescription());
        author.setAuthorName(from.getAuthorName());

        return author;
    }

    public AuthorEntity mapAuthorEntityFromAuthor(Author from) {
        AuthorEntity entity = new AuthorEntity();
        entity.setAuthorId(UUID.randomUUID().toString());
        entity.setAuthorAvatar(from.getAuthorAvatar());
        entity.setAuthorName(from.getAuthorName());
        entity.setAuthorDescription(from.getAuthorDescription());
        entity.setAuthorEmail(from.getAuthorEmail());

        return entity;
    }

    public AuthorList mapAuthorListFroAuthorEntities(List<AuthorEntity> from) {
        AuthorList authorList = new AuthorList();

        from.forEach(authorEntity -> {
            authorList.add(mapAuthorFromAuthorEntity(authorEntity));
        });

        return authorList;

    }

    public AuthorEntity mapAuthorEntityFromAuthorRequest(String id, AuthorRequest from) {
        AuthorEntity entity = repository.getById(id);

        entity.setAuthorEmail(from.getAuthorEmail());
        entity.setAuthorDescription(from.getAuthorDescription());
        entity.setAuthorAvatar(from.getAuthorAvatar());
        entity.setAuthorName(from.getAuthorName());

        return entity;


    }

    public AuthorEntity mapAuthorEntityFromAuthorRequest(AuthorRequest request){
        AuthorEntity entity = new AuthorEntity();
        entity.setAuthorId(UUID.randomUUID().toString());
        entity.setAuthorAvatar(request.getAuthorAvatar());
        entity.setAuthorEmail(request.getAuthorEmail());
        entity.setAuthorDescription(request.getAuthorDescription());
        entity.setAuthorName(request.getAuthorName());

        return entity;
    }
}
