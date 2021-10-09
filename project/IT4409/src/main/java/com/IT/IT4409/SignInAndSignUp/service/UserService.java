package com.IT.IT4409.SignInAndSignUp.service;


import com.IT.IT4409.entity.Role;
import com.IT.IT4409.entity.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);

    public String sendEmail(String to, String body);

    public void saveRole(Role role);

    public User findUserById(Integer id);

    public void updateUser(Integer id, String fullName, String phoneNumber, String company, String country);
}