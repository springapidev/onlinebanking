package com.coderbd.controller;

import com.coderbd.entity.Account;
import com.coderbd.entity.TransactionDetails;
import com.coderbd.entity.TransactionSummary;
import com.coderbd.entity.TransactionType;
import com.coderbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/account/")
public class AccountController {
    @Autowired
    private AccountRepo repo;

    @Autowired
    private AccountTypeRepo accountTypeRepo;

    @Autowired
    private NomineeRepo nomineeRepo;

    @Autowired
    private TransactionSummaryRepo summaryRepo;
    @Autowired
    private TransactionDetailsRepo detailsRepo;

    @GetMapping(value = "create.jsf")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Account());
        modelAndView.addObject("accounttypelist", accountTypeRepo.findAll());
        modelAndView.addObject("nomnieelist", nomineeRepo.findAll());
        modelAndView.addObject("obj", new Account());
        modelAndView.setViewName("accounts/create");
        return modelAndView;
    }

    @PostMapping(value = "create.jsf")
    public ModelAndView save(@Valid Account obj, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        Account account1 = repo.findByAccountNumber(obj.getAccountNumber());
        if (account1 == null) {
            repo.save(obj);
            modelAndView.addObject("accounttypelist", accountTypeRepo.findAll());
            modelAndView.addObject("nomnieelist", nomineeRepo.findAll());
            Account account = repo.findByAccountNumber(obj.getAccountNumber());

            TransactionSummary summary = summaryRepo.findByAccount(account);
            summary.setAccount(account);
            summary.setBlanceAmount(obj.getPrimaryDepositAmount());
            summary.setDepositAmount(obj.getPrimaryDepositAmount());
            summary.setLastUpdate(new Date());
            summaryRepo.save(summary);

            TransactionDetails transactionDetails=new TransactionDetails();
            transactionDetails.setAccount(account);
            transactionDetails.setDepositAmount(obj.getPrimaryDepositAmount());
            TransactionType ty=new TransactionType();
            ty.setTypeName("deposit");
            transactionDetails.setTransactionType(ty);
            transactionDetails.setTransDate(new Date());
            detailsRepo.save(transactionDetails);

            modelAndView.addObject("successMsg", "Save Success");
            modelAndView.addObject("obj", new Account());

            modelAndView.setViewName("accounts/create");
        }
        modelAndView.setViewName("accounts/create");
        return modelAndView;
    }

    @GetMapping(value = "list.jsf")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", repo.findAll());
        modelAndView.setViewName("accounts/list");
        return modelAndView;
    }



}
