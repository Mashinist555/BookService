package com.summerschool.bookservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RootController {

    @RequestMapping("/")
    public String examplePageWithModel(ModelMap model) {
        model.addAttribute("parameter", "valueOfParameter");
        return "testPage";
    }
}
