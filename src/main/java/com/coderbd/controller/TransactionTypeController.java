package com.coderbd.controller;

import com.coderbd.entity.AccountType;
import com.coderbd.entity.TransactionType;
import com.coderbd.repo.AccountTypeRepo;
import com.coderbd.repo.TransactionTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/tr-type/")
public class TransactionTypeController {
    @Autowired
    private TransactionTypeRepo repo;

    @GetMapping(value = "create.jsf")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new TransactionType());
        modelAndView.setViewName("transaction-types/create");
        return modelAndView;
    }

    @PostMapping(value = "create.jsf")
    public ModelAndView save(@Valid TransactionType obj, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (obj != null) {
            repo.save(obj);
            modelAndView.addObject("obj", new TransactionType());
            modelAndView.setViewName("transaction-types/create");
        }
        modelAndView.setViewName("transaction-types/create");
        return modelAndView;
    }

    @GetMapping(value = "list.jsf")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", repo.findAll());
        modelAndView.setViewName("transaction-types/list");
        return modelAndView;
    }

}
