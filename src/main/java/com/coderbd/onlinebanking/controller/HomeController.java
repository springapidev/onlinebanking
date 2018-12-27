package com.coderbd.onlinebanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayHome(){
        return "index";
    }

    @GetMapping(value = "/tt.jsf")
    public String displayTest(){
        return "test";
    }

    @GetMapping(value = "/fo.jsf")
    public String displayFoo(){
        return "foo/bar";
    }
}
