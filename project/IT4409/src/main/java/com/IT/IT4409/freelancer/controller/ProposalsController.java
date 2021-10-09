package com.IT.IT4409.freelancer.controller;

import com.IT.IT4409.SignInAndSignUp.service.UserService;
import com.IT.IT4409.SignInAndSignUp.service.UserServiceImpl;
import com.IT.IT4409.entity.Proposal;
import com.IT.IT4409.entity.User;
import com.IT.IT4409.freelancer.service.AuthService;
import com.IT.IT4409.freelancer.service.JobService;
import com.IT.IT4409.freelancer.service.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProposalsController {

    @Autowired
    AuthService authService;

    @Autowired
    JobService jobService;

    @Autowired
    ProposalService proposalService;

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JobsController.class);

    /**
     * Show form to create and submit proposal for a job
     *
     * @param jobPostId
     * @param model
     * @return String
     */
    @GetMapping("/find-work/recommended/{jobPostId}/create-proposal")
    public String showFormCreateProposal(@PathVariable("jobPostId") long jobPostId, Model model){
        model.addAttribute("jobPost", jobService.findById(jobPostId));
        model.addAttribute("freelancer", authService.getUser());
        model.addAttribute("proposal", new Proposal());
        return "job/create-proposal";
    }

    /**
     * Store a proposal
     *
     * @param jobPostId
     * @param model
     * @return String
     */
    @PostMapping("/find-work/recommended/{jobPostId}/proposals")
    public String store(@PathVariable("jobPostId") long jobPostId, @ModelAttribute Proposal proposal, Model model) {

        LOGGER.info(proposal.getDescription());
        LOGGER.info(String.valueOf(proposal.getJobPostId()));

        User user = authService.getUser();
        Integer result = proposalService.store(proposal.getBudget(), proposal.getDescription(), user.getId(), proposal.getJobPostId(), proposal.getTimeRequirement());

        String abc = user.getFullname();

        userService.sendEmail(user.getEmail(), abc + " has applied for your job");

        LOGGER.info(String.valueOf(result));

        return "job/store-proposal-result";
    }

    /**
     * Display list proposals of freelancer
     *
     * @param model
     * @return String
     */
    @GetMapping("/f/proposals")
    public String index(Model model) {

        User user = authService.getUser();

        List<Proposal> proposals = proposalService.indexByFreelancerId(user.getId());

        LOGGER.info(String.valueOf(proposals.size()));

//        LOGGER.info(String.valueOf(proposals.get(0).isStatus()));

        model.addAttribute("proposals", proposals);

        return "freelancer/my-proposals";
    }
}
