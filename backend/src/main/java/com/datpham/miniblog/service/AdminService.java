package com.datpham.miniblog.service;


import com.datpham.miniblog.entity.AdminEntity;
import com.datpham.miniblog.mapper.AdminMapper;
import com.datpham.miniblog.repository.AdminRepository;
import io.tej.SwaggerCodgen.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminMapper mapper;
    private final AdminRepository repository;

    @Autowired
    public AdminService(AdminMapper mapper, AdminRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Admin getAdmin() {
        List<AdminEntity> entity = repository.findAll();

        return mapper.mapAdminFromAdminEntity(entity.get(0));
    }
}
