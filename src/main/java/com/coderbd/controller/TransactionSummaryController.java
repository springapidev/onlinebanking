package com.coderbd.controller;

import com.coderbd.entity.AccountType;
import com.coderbd.entity.TransactionSummary;
import com.coderbd.repo.AccountTypeRepo;
import com.coderbd.repo.TransactionSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/tr-summary/")
public class TransactionSummaryController {
    @Autowired
    private TransactionSummaryRepo repo;

    @GetMapping(value = "list.jsf")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", repo.findAll());
        modelAndView.setViewName("tr-summary/list");
        return modelAndView;
    }

}
