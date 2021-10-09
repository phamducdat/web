package com.IT.IT4409.boss.controller;

import com.IT.IT4409.SignInAndSignUp.service.UserService;
import com.IT.IT4409.boss.service.BossService;
import com.IT.IT4409.entity.Contract;
import com.IT.IT4409.entity.JobPost;
import com.IT.IT4409.entity.Proposal;
import com.IT.IT4409.entity.User;
import com.IT.IT4409.freelancer.service.ContractService;
import com.IT.IT4409.freelancer.service.ProposalService;
import com.IT.IT4409.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RequestMapping("/boss")
@Controller
public class BossController extends AbstractController {

    @Autowired
    BossService bossService;

    @Autowired
    UserService userService;

    @Autowired
    ProposalService proposalService;

    @Autowired
    ContractService contractService;

    @Autowired
    UserRepository userRepository;


    /**
     * Hien thi trang chu cua boss
     * @return ModelAndView
     */
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        model.setViewName("boss/home");
        return  model;
    }

    /**
     * Hien thi form tao job
     * @return ModelAndView
     */
    @RequestMapping(value = {"/job_post"}, method = RequestMethod.GET)
    public ModelAndView createPost() {
        ModelAndView model = new ModelAndView();
        model.addObject("jobPost", new JobPost());
        model.setViewName("boss/job_post");
        return model;
    }

    /**
     * Hien thi cac job nguoi dung da dang
     * @return ModelAndView
     */
    @RequestMapping(value = {"/see_all_post"}, method = RequestMethod.GET)
    public ModelAndView seeAllPost() {
        ModelAndView modelAndView = new ModelAndView();
        User author = super.getCurrentUser();

        List<JobPost> listJobPost = bossService.findJobByAuthor(author);
        modelAndView.addObject("listJobPost", listJobPost);

        modelAndView.setViewName("boss/see_all_post");
        return modelAndView;
    }

    /**
     * Luu job da dang vao database, hien thi trang review job vua dang
     * @param jobPost
     * @param bindingResult
     * @return ModelAndView
     */
    @RequestMapping(value = {"/review-post"}, method = RequestMethod.POST)
    public ModelAndView createPost(@Valid JobPost jobPost, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobPost", new JobPost());
        User author = super.getCurrentUser();
        jobPost.setAuthor(author);
        Instant instant = Instant.now();
        long timeStampSeconds = instant.getEpochSecond();

        bossService.saveJobPost(jobPost);
        modelAndView.addObject("job", jobPost);
        modelAndView.setViewName("boss/review-post");
        return modelAndView;
    }

    /**
     * Xoa job, hien thi cac job sau khi xoa
     * @param id
     * @return redirect
     */
    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteJob(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        bossService.deleteJobPost(id);
        return "redirect:/boss/see_all_post";
    }

    /**
     * Hien thi thong tin chi tiet cua mot job
     * @param id
     * @return ModelAndView
     */
    @RequestMapping(value = {"/view/{id}"}, method = RequestMethod.GET)
    public ModelAndView viewJob(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        JobPost jobPost = bossService.findById(id);
        modelAndView.addObject("view", jobPost);
        modelAndView.setViewName("boss/view-post");
        return modelAndView;
    }

    /**
     * Hien thi cac proposal cua mot job
     * @param id
     * @return ModelAndView
     */
    @RequestMapping(value = {"/proposals/{id}"}, method = RequestMethod.GET)
    public ModelAndView viewProposals(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Proposal> listProposal = proposalService.listProposal(id);
        JobPost jobPost = bossService.findById(id);
        modelAndView.addObject("jobPost", jobPost);
        modelAndView.addObject("listProposal", listProposal);
        modelAndView.setViewName("boss/proposals");
        return modelAndView;
    }

    /**
     * Hien thi trang edit job
     * @param id
     * @return ModelAndView
     */
    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView editJob(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        JobPost jobPost = bossService.findById(id);
        modelAndView.addObject("jobEdit", jobPost);
        modelAndView.setViewName("boss/update-post");
        return modelAndView;
    }

    /**
     * Luu job sau khi da chinh sua, tra ve trang thong tin chi tiet cua job sau khi chinh sua
     * @param id
     * @param jobPost
     * @param bindingResult
     * @return redirect
     */
    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.POST)
    public String updateJob(@PathVariable("id") long id, @Valid JobPost jobPost, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        JobPost jobPost1 = bossService.findById(id);
        jobPost1.setTitle(jobPost.getTitle());
        jobPost1.setDescription(jobPost.getDescription());
        jobPost1.setType(jobPost.getType());
        jobPost1.setBudget(jobPost.getBudget());
        jobPost1.setExpertiseLevel(jobPost.getExpertiseLevel());
        jobPost1.setTimeRequirement(jobPost.getTimeRequirement());
        jobPost1.setSkill(jobPost.getSkill());
        bossService.saveJobPost(jobPost1);
        return "redirect:/boss/view/{id}";
    }

    /**
     * Hien thi profile cua boss
     * @return ModelAndView
     */
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public ModelAndView viewProfile() {
        ModelAndView modelAndView = new ModelAndView();
        User boss = super.getCurrentUser();
        modelAndView.addObject("boss", boss);
        modelAndView.setViewName("boss/profile");
        System.out.println("profile");
        return modelAndView;
    }

    /**
     * Hien thi form thay doi profile
     * @return ModelAndView
     */
    @RequestMapping(value = {"/change-profile"}, method = RequestMethod.GET)
    public ModelAndView editProfile() {
        ModelAndView modelAndView = new ModelAndView();
        User boss = super.getCurrentUser();
        modelAndView.addObject("boss", boss);
        modelAndView.setViewName("boss/update-profile");
        return modelAndView;
    }

    /**
     * Luu thong tin nguoi dung sau khi da cap nhat, tra ve profile voi cac thong tin da cap nhat
     * @param user
     * @param bindingResult
     * @return redirect
     */
    @RequestMapping(value = {"/profile"}, method = RequestMethod.POST)
    public String updateProfile(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        String fullName = user.getFullname();
        String phoneNumber = user.getPhone();
        String company = user.getCompany();
        String country = user.getCountry();
        User boss = super.getCurrentUser();
        int id = (int) boss.getId();
        userService.updateUser(id, fullName, phoneNumber, company, country);
        return "redirect:/boss/profile";
    }

    /**
     * Hien thi trang gioi thieu cong ty
     * @return ModelAndView
     */
    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("boss/about");
        return modelAndView;
    }

    /**
     * Tao contract
     * @param proposal
     * @param id
     * @param bindingResult
     * @return redirect
     */
    @RequestMapping(value = {"/create/{id}"}, method = RequestMethod.GET)
    public String createContract(@Valid Proposal proposal, @PathVariable("id") Long id, BindingResult bindingResult) {
        Contract contract = new Contract();
        Proposal proposal1 = proposalService.findProposal(id);

        contract.setFreelancerId(proposal1.getFreelancer().getId());
        System.out.println(proposal1.getFreelancer().getId() +"okkkkkkkkkkkkkkkkkkkkkkkkkkk");
        User employee = userRepository.findById(proposal1.getFreelancer().getId());
        System.out.println(employee.getEmail() + "lllllllllllllllllllllllllllll");
        userService.sendEmail(employee.getEmail(), "You has applied for the job");
        contract.setJobPostId(proposal1.getJobPostId());
        User boss = super.getCurrentUser();

        contract.setBossId(boss.getId());
        contract.setAcive(true);
        contract.setProposal(proposal1);
        contractService.createContract(contract);
        JobPost jobPost = bossService.findById(proposal1.getJobPostId());
        jobPost.setActive(true);
        bossService.saveJobPost(jobPost);
        proposal1.setStatus(true);
        proposalService.saveProposal(proposal1);

        return "redirect:/boss/see_all_post";

    }

}



