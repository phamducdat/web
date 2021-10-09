package com.IT.IT4409.SignInAndSignUp;

import com.IT.IT4409.entity.Role;
import com.IT.IT4409.entity.User;
import com.IT.IT4409.repo.RoleRespository;
import com.IT.IT4409.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRespository roleRespository;

    @Lazy
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //Roles
        if (roleRespository.findByRole("ROLE_ADMIN") == null) {
            Role role = new Role();
            role.setRole("ROLE_ADMIN");
            roleRespository.save(role);
        }

        if (roleRespository.findByRole("ROLE_BOSS") == null) {
            Role role = new Role();
            role.setRole("ROLE_BOSS");
            roleRespository.save(role);
        }

        if (roleRespository.findByRole("ROLE_EMPLOYEE") == null) {
            Role role = new Role();
            role.setRole("ROLE_EMPLOYEE");
            roleRespository.save(role);
        }


//        admin
        if (userRepository.findByEmail("admin@gmail.com") == null) {
            User admin = new User();
            admin.setRates("10");
            admin.setCompany("a");
            admin.setEducation("a");
            admin.setPhone("10");
            admin.setSkills("a");
            admin.setCountry("a");
            admin.setEmail("admin@gmail.com");
            admin.setFullname("a");
            admin.setPassword(bCryptPasswordEncoder.encode("123"));
            Role adminRole = roleRespository.findByRole("ROLE_ADMIN");
            admin.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
            userRepository.save(admin);
        }

        //boss
        if (userRepository.findByEmail("boss@gmail.com") == null) {
            User boss = new User();
            boss.setFullname("boss");
            boss.setEmail("boss@gmail.com");
            boss.setCompany("FPT");
            boss.setEducation("HUST");
            boss.setPhone("0977289504");
            boss.setCountry("Viet Nam");
            boss.setPassword(bCryptPasswordEncoder.encode("123"));
            Role bossRole = roleRespository.findByRole("ROLE_BOSS");
            boss.setRoles(new HashSet<Role>(Arrays.asList(bossRole)));
            userRepository.save(boss);

        }

        //employer
        if (userRepository.findByEmail("employee@gmail.com") == null) {
            User employee = new User();
            employee.setFullname("employee");
            employee.setEmail("employee@gmail.com");
            employee.setRates("100");
            employee.setCompany("MISA");
            employee.setEducation("HUST");
            employee.setPhone("0977289504");
            employee.setSkills("Java, Python");
            employee.setCountry("Viet Nam");
            employee.setPassword(bCryptPasswordEncoder.encode("123"));
            Role employeeRole = roleRespository.findByRole("ROLE_EMPLOYEE");
            employee.setRoles(new HashSet<Role>(Arrays.asList(employeeRole)));
            userRepository.save(employee);

        }

        if (userRepository.findByEmail("phamducdat2402@gmail.com") == null) {
            User boss = new User();
            boss.setFullname("Pham Duc Dat");
            boss.setEmail("phamducdat2402@gmail.com");
            boss.setCompany("FPT");
            boss.setEducation("HUST");
            boss.setPhone("0977289509");
            boss.setCountry("Viet Nam");
            boss.setPassword(bCryptPasswordEncoder.encode("123"));
            Role bossRole = roleRespository.findByRole("ROLE_BOSS");
            boss.setRoles(new HashSet<Role>(Arrays.asList(bossRole)));
            userRepository.save(boss);

        }

        if (userRepository.findByEmail("phamducdat242@gmail.com") == null) {
            User employee = new User();
            employee.setFullname("Pham Duc Dung");
            employee.setEmail("phamducdat242@gmail.com");
            employee.setRates("100");
            employee.setCompany("SUN");
            employee.setEducation("HUST");
            employee.setPhone("0977289504");
            employee.setSkills("Java, Python");
            employee.setCountry("Viet Nam");
            employee.setPassword(bCryptPasswordEncoder.encode("123"));
            Role employeeRole = roleRespository.findByRole("ROLE_EMPLOYEE");
            employee.setRoles(new HashSet<Role>(Arrays.asList(employeeRole)));
            userRepository.save(employee);

        }
    }
}
