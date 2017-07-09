package com.summerschool.bookservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("/")
    public String examplePageWithModel(ModelMap model) {
        model.addAttribute("parameter", "valueOfParameter");
        return "testPage";
    }
}
