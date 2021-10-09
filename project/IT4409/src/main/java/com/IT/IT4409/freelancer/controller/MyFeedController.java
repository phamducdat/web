package com.IT.IT4409.freelancer.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.IT.IT4409.boss.service.BossService;
import com.IT.IT4409.entity.JobPost;
import com.IT.IT4409.freelancer.service.JobService;
import com.IT.IT4409.model.AjaxResponseBody;
import com.IT.IT4409.model.JobSpecificationsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class MyFeedController {

    BossService bossService;

    @Autowired
    JobService jobService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JobsController.class);

    @Autowired
    public void setBossService(BossService bossService) {
        this.bossService = bossService;
    }

    @RequestMapping(value = {"/find-work"}, method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user/find-work");
        return model;
    }

    /**
     * Get details of a job
     *
     * @param id
     * @return String
     */
    @GetMapping(value = "/find-work/recommended/{id}")
    public String getJobDetails(@PathVariable("id") long id, Model model) {

        JobPost jobPost = jobService.findById(id);

        LOGGER.info("Job id = " + String.valueOf(jobPost.getId()));

        model.addAttribute("jobPost", jobPost);

        return "job/details";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/job")
    @ResponseBody
    public ResponseEntity<?> search(@RequestParam(value = "search") String search,
                                    @RequestParam("page") int page,
                                    @RequestParam("size") int size,
                                    @RequestParam("sortBy") String sortBy) {
        JobSpecificationsBuilder builder = new JobSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)([\\w\\s]+),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3), false);
        }
        builder.with("isActive", ":", 0, false);
        Specification<JobPost> spec = builder.build();

        Pageable pageable;

        if (sortBy.equalsIgnoreCase("default")) {
            pageable = PageRequest.of(page, size, Sort.by("createdTime").descending());
        } else {
            pageable = PageRequest.of(page, size, Sort.by(sortBy).and(Sort.by("createdTime").descending()));
        }

        Page<JobPost> pages = this.bossService.findAll(spec, pageable);

        AjaxResponseBody result = new AjaxResponseBody();
        if (pages.hasNext()) {
            result.setMsg("has next");
        } else {
            result.setMsg("end");
        }
        result.setTotal(String.valueOf(pages.getTotalElements()));
        result.setLinks(pages.toList());
        return ResponseEntity.ok(result);
    }
}
