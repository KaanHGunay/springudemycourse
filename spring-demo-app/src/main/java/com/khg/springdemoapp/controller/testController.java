package com.khg.springdemoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class testController {

    @GetMapping("test1")
    @ResponseBody
    public String test1() {
        return "test worked";
    }

    @GetMapping("test2")
    @ResponseBody
    public String test2() {
        return "test worked";
    }
}
