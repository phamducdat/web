package com.IT.IT4409.freelancer.service;

import com.IT.IT4409.SignInAndSignUp.service.UserService;
import com.IT.IT4409.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserService userService;

    /**
     * Get current freelancer
     * @return User
     */
    @Override
    public User getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails == false) {
            return null;
        }
        String username = ((UserDetails) principal).getUsername();

        return userService.findUserByEmail(username);
    }
}
