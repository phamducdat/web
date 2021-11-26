package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.AdminEntity;
import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.repository.AdminRepository;
import com.datpham.miniblog.repository.AuthorRepository;
import io.tej.SwaggerCodgen.model.Author;
import io.tej.SwaggerCodgen.model.AuthorList;
import io.tej.SwaggerCodgen.model.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorMapper {

    private final AuthorRepository repository;
    private final AdminRepository adminRepository;

    @Autowired
    private final  BCryptPasswordEncoder bCryptPasswordEncoder;




    @Autowired
    public AuthorMapper(AuthorRepository repository, AdminRepository adminRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.adminRepository = adminRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Author mapAuthorFromAuthorEntity(AuthorEntity from) {
        Author author = new Author();
        author.setAdminId(from.getAdminId().getAdminId());
        author.setAuthorPassword(from.getAuthorPassword());
        author.setAuthorId(from.getAuthorId());
        author.setAuthorAvatar(from.getAuthorAvatar());
        author.setAuthorEmail(from.getAuthorEmail());
        author.setAuthorPhone(from.getAuthorPhone());
        author.setAuthorDescription(from.getAuthorDescription());
        author.setAuthorName(from.getAuthorName());
        author.setAuthorDateOfBirth(from.getAuthorDateOfBirth());

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
        entity.setAuthorPassword(bCryptPasswordEncoder.encode(from.getAuthorPassword()));
        entity.setAuthorDateOfBirth(from.getAuthorDateOfBirth());
        entity.setAuthorPhone(from.getAuthorPhone());


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
        entity.setAuthorPhone(request.getAuthorPhone());
        entity.setAuthorName(request.getAuthorName());
        entity.setAuthorPassword(bCryptPasswordEncoder.encode(request.getAuthorPassword()));
        entity.setAuthorDateOfBirth(request.getAuthorDateOfBirth());

        return entity;
    }
}
