package com.datpham.miniblog.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {

    public static void main(String[] args) {
        String password = "123";
        BCryptPasswordEncoder bCryptPasswordEncoder  = new BCryptPasswordEncoder();
        String result  = bCryptPasswordEncoder.encode(password);

        boolean isPassword = bCryptPasswordEncoder.matches("123", result);
        System.out.println(result);
        System.out.println(isPassword);
    }
}
