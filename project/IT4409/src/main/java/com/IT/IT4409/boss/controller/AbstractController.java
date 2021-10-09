package com.IT.IT4409.boss.controller;

import com.IT.IT4409.SignInAndSignUp.service.UserService;
import com.IT.IT4409.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public abstract class AbstractController {

    @Autowired
    UserService userService;

    protected User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails == false) {
            return null;
        }
        String username = ((UserDetails) principal).getUsername();

        return userService.findUserByEmail(username);
    }
}



