package com.datpham.miniblog.repository;


import com.datpham.miniblog.entity.AuthorEntity;
import io.tej.SwaggerCodgen.model.AuthorRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, String> {

    List<AuthorEntity> findAll();

}
