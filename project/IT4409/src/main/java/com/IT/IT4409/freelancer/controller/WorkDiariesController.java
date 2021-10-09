package com.IT.IT4409.freelancer.controller;

import com.IT.IT4409.freelancer.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkDiariesController {

    @Autowired
    AuthService authService;

    /**
     * Get freelancer's diary
     * @return String
     */
    @GetMapping("/f/work-diary")
    public String workDiary(Model model) {
        model.addAttribute("user", authService.getUser());
        return "freelancer/work-diary";
    }
}
