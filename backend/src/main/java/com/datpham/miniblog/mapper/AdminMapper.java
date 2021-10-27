package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.AdminEntity;
import io.tej.SwaggerCodgen.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMapper {


    public Admin mapAdminFromAdminEntity(AdminEntity from) {
        Admin to = new Admin();

        to.setAdminEmail(from.getAdminEmail());
        to.setAdminId(from.getAdminId());
        to.setAdminName(from.getAdminName());
        to.setAdminPassword(from.getAdminPassword());

        return  to;
    }
}
