package com.IT.IT4409.SignInAndSignUp.service;
import com.IT.IT4409.boss.controller.AbstractController;
import com.IT.IT4409.entity.Role;
import com.IT.IT4409.entity.User;
import com.IT.IT4409.repo.RoleRespository;
import com.IT.IT4409.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service("userService")
public class UserServiceImpl extends AbstractController implements UserService, UserDetailsService{


    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRespository roleRespository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole;
        if (user.getRates()!= null){
            userRole = roleRespository.findByRole("ROLE_EMPLOYEE");
        }else {
            userRole = roleRespository.findByRole("ROLE_BOSS");
        }
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public String sendEmail(String to, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("phamducdat2402@gmail.com");
        message.setTo(to);
        message.setSubject("Up Work");
        message.setText(body);
        message.setReplyTo("phamducdat2402@gmail.com");

        javaMailSender.send(message);

        return "Mail sent successfully";
    }

    @Override
    public void saveRole(Role role) {
        roleRespository.save(role);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(Integer id, String fullName, String phoneNumber, String company, String country) {
        User user = userRepository.findById(id);
        user.setFullname(fullName);
        user.setPhone(phoneNumber);
        user.setCompany(company);
        user.setCountry(country);
        userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not Found = " + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role: roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), grantedAuthorities);

    }

}
