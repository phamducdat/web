package com.datpham.miniblog.repository;

import com.datpham.miniblog.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactEntity, String> {

    List<ContactEntity> findAll();
}
