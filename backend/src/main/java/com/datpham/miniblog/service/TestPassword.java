package com.datpham.miniblog.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {

    public static void main(String[] args) {
        String password = "123";
        BCryptPasswordEncoder bCryptPasswordEncoder  = new BCryptPasswordEncoder();
        String result  = bCryptPasswordEncoder.encode(password);

        String encode = "$2a$10$3ttj4xzFQUBmJ8Xm1loyeOp5Yo4v/pwvpkQWwC4Yo550IOkseSS6K";
        boolean isPassword = bCryptPasswordEncoder.matches("123", encode);
        System.out.println(result);
        System.out.println(isPassword);
    }
}
