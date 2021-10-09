package com.IT.IT4409.freelancer.controller;

import com.IT.IT4409.entity.Contract;
import com.IT.IT4409.entity.User;
import com.IT.IT4409.freelancer.service.AuthService;
import com.IT.IT4409.freelancer.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
public class ContractsController {

    @Autowired
    ContractService contractService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContractsController.class);

    @Autowired
    AuthService authService;

    /**
     * Get all freelancer's contracts
     * @return String
     */
    @GetMapping("/f/contracts")
    public String contracts(Model model) {

        User user = authService.getUser();

        List<Contract> contracts = contractService.getFreelancerContracts(user.getId());

        model.addAttribute("user", user);

        model.addAttribute("contracts", contracts);

        return "freelancer/contracts";
    }
}
