package com.IT.IT4409.freelancer.controller;

import com.IT.IT4409.entity.User;
import com.IT.IT4409.freelancer.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobsController {

    @Autowired
    AuthService authService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JobsController.class);

    /**
     * Get first page show freelance's jobs when he/she log in
     * @return String
     */
    @GetMapping("/f/home")
    public String home(Model model) {
        User user = authService.getUser();
        LOGGER.info(user.getFullname());
        model.addAttribute("user", user);
        return "freelancer/my-jobs";
    }
}
