package com.datpham.miniblog.repository;

import com.datpham.miniblog.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogEntity, String> {

    List<BlogEntity> findAll();
}
