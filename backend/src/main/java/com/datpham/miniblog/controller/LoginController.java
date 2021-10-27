package com.datpham.miniblog.controller;

import com.datpham.miniblog.service.AdminService;
import com.datpham.miniblog.service.AuthorService;
import io.tej.SwaggerCodgen.api.LoginApi;
import io.tej.SwaggerCodgen.model.Admin;
import io.tej.SwaggerCodgen.model.AdminLogin;
import io.tej.SwaggerCodgen.model.Author;
import io.tej.SwaggerCodgen.model.AuthorLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/miniblogs/backend/v1")
public class LoginController implements LoginApi {

    private final AdminService adminService;
    private final AuthorService authorService;

    @Autowired
    public LoginController(AdminService adminService, AuthorService authorService) {
        this.adminService = adminService;
        this.authorService = authorService;
    }

    @Override
    public ResponseEntity<Admin> loginAdmin(AdminLogin adminLogin) {
        Admin admin = adminService.loginAdmin(adminLogin);
        if (null != admin) return new ResponseEntity<>(admin, HttpStatus.OK);
        return  new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @Override
    public ResponseEntity<Author> loginAuthor(AuthorLogin authorLogin) {
        Author author = authorService.loginAuthor(authorLogin);
        if (author != null) return new ResponseEntity<>(author, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
}
