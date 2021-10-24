package com.datpham.miniblog.controller;


import com.datpham.miniblog.service.AdminService;
import io.tej.SwaggerCodgen.api.AdminApi;
import io.tej.SwaggerCodgen.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/miniblogs/backend/v1")
public class AdminController implements AdminApi {

    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<Admin> getAdmin() {
        Admin admin = service.getAdmin();

        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}
