package com.datpham.miniblog.service;


import com.datpham.miniblog.entity.AdminEntity;
import com.datpham.miniblog.mapper.AdminMapper;
import com.datpham.miniblog.repository.AdminRepository;
import io.tej.SwaggerCodgen.model.Admin;
import io.tej.SwaggerCodgen.model.AdminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminMapper mapper;
    private final AdminRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminService(AdminMapper mapper, AdminRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Admin getAdmin() {
        List<AdminEntity> entity = repository.findAll();

        return mapper.mapAdminFromAdminEntity(entity.get(0));
    }

    public Admin loginAdmin(AdminLogin adminLogin) {
        List<AdminEntity> adminEntityList = repository.findAll();
        for (AdminEntity adminEntity: adminEntityList) {
            if (adminLogin.getAdminEmail().equals(adminEntity.getAdminEmail())) {
                if (bCryptPasswordEncoder.matches(adminLogin.getAdminPassword(), adminEntity.getAdminPassword() )) {
                    return mapper.mapAdminFromAdminEntity(adminEntity);
                }
            }
        }
        return  null;
    }
}
