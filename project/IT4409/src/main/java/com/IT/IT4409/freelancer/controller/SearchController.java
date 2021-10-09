package com.IT.IT4409.freelancer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @RequestMapping(value = {"/f/search"}, method = RequestMethod.GET)
    public ModelAndView getPage(@RequestParam(value = "q") String q) {
        System.out.println(q);
        ModelAndView model = new ModelAndView();
        model.addObject("q", q);
        model.setViewName("user/search-page");
        return model;
    }

}
