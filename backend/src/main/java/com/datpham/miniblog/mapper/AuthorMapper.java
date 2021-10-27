package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.AdminEntity;
import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.repository.AdminRepository;
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
    private final AdminRepository adminRepository;


    @Autowired
    public AuthorMapper(AuthorRepository repository, AdminRepository adminRepository) {
        this.repository = repository;
        this.adminRepository = adminRepository;
    }

    public Author mapAuthorFromAuthorEntity(AuthorEntity from) {
        Author author = new Author();
        author.setAdminId(from.getAdminId().getAdminId());
        author.setAuthorPassword(from.getAuthorPassword());
        author.setAuthorId(from.getAuthorId());
        author.setAuthorAvatar(from.getAuthorAvatar());
        author.setAuthorEmail(from.getAuthorEmail());
        author.setAuthorDescription(from.getAuthorDescription());
        author.setAuthorName(from.getAuthorName());

        return author;
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
        AdminEntity adminEntity = adminRepository.getById(from.getAdminId());

        entity.setAdminId(adminEntity);
        entity.setAuthorEmail(from.getAuthorEmail());
        entity.setAuthorDescription(from.getAuthorDescription());
        entity.setAuthorAvatar(from.getAuthorAvatar());
        entity.setAuthorName(from.getAuthorName());
        entity.setAuthorPassword(from.getAuthorPassword());

        return entity;


    }

    public AuthorEntity mapAuthorEntityFromAuthorRequest(AuthorRequest request){
        AuthorEntity entity = new AuthorEntity();
        AdminEntity adminEntity = adminRepository.getById(request.getAdminId());

        entity.setAdminId(adminEntity);
        entity.setAuthorId(UUID.randomUUID().toString());
        entity.setAuthorAvatar(request.getAuthorAvatar());
        entity.setAuthorEmail(request.getAuthorEmail());
        entity.setAuthorDescription(request.getAuthorDescription());
        entity.setAuthorName(request.getAuthorName());
        entity.setAuthorPassword(request.getAuthorPassword());

        return entity;
    }
}
