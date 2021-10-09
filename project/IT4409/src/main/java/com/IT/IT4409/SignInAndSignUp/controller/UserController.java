package com.IT.IT4409.SignInAndSignUp.controller;
import javax.validation.Valid;

import com.IT.IT4409.SignInAndSignUp.service.UserService;
import com.IT.IT4409.SignInAndSignUp.service.UserServiceImpl;
import com.IT.IT4409.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user/login");
        return model;
    }

    @RequestMapping(value= {"/signupEmployee"}, method=RequestMethod.GET)
    public ModelAndView signupEmployee() {
        ModelAndView model = new ModelAndView();
        User user = new User();

        model.addObject("user", user);
        model.setViewName("user/signup");

        model.addObject("user", user);
        model.setViewName("user/signupEmployee");

        return model;
    }

    @RequestMapping(value= {"/signupBoss"}, method=RequestMethod.GET)
    public ModelAndView signupBoss() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signupBoss");

        return model;
    }

    @RequestMapping(value= {"/signupEmployee"}, method=RequestMethod.POST)
    public ModelAndView createUserEmployee(@Valid User user, BindingResult bindingResult) {
        System.out.println("Test"); // Them moi ma nguon
        ModelAndView model = new ModelAndView();
        System.out.println("input = " + user.getEmail());
        User userExists = userService.findUserByEmail(user.getEmail());
        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
            model.addObject("msg", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signupEmployee");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("user/signupEmployee");
        }

        return model;
    }

    @RequestMapping(value= {"/signupBoss"}, method=RequestMethod.POST)
    public ModelAndView createUserBoss(@Valid User user, BindingResult bindingResult) {
        System.out.println("Test"); // Them moi ma nguon
        ModelAndView model = new ModelAndView();
        System.out.println("input = " + user.getEmail());
        User userExists = userService.findUserByEmail(user.getEmail());
        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
            model.addObject("msg", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signupBoss");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user123", new User());
            model.setViewName("user/signupBoss");
        }
        return model;
    }

    @RequestMapping(value= {"/home/default"}, method=RequestMethod.GET)
    public String home() {
        Collection<? extends GrantedAuthority> authorities;
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String BOSS = "ROLE_BOSS";
        System.out.println("MyRole = " + myRole);
        if (myRole.equals(BOSS)) {
            // model.setViewName("home/boss");

            // Redirect to main page for BOSS user
            return "redirect:/boss/home";
        }else {
            model.addObject("userName", user.getFullname());
            return "redirect:/find-work";
        }
    }

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }

    @GetMapping(value = "/intro" )
    public ModelAndView intro(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/intro");
        return modelAndView;
    }

    @GetMapping(value = "/my-profile")
    public ModelAndView updateProfile() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/my-profile");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        this.userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/f/{id}/profile")
    public ModelAndView viewProfile(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = this.userService.findUserById(id);
        modelAndView.setViewName("user/profile");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
//tạo job ở đâu?