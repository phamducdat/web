package com.datpham.miniblog.repository;

import com.datpham.miniblog.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {

    List<AdminEntity> findAll();
}
