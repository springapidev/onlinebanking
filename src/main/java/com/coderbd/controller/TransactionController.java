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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class TransactionController {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private TransactionSummaryRepo summaryRepo;
    @Autowired
    private TransactionDetailsRepo detailsRepo;

    @Autowired
    private TransactionTypeRepo typeRepo;

    @GetMapping(value = "/tr.jsf")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Account());
        modelAndView.addObject("trTypelist", typeRepo.findAll());
        modelAndView.addObject("obj", new TransactionDetails());
        modelAndView.setViewName("tr-details/tr");
        return modelAndView;
    }
    @GetMapping(value = "/tr-info.jsf")
    public ModelAndView getAccountInfo(@Valid Account accountinfo, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountinfo", summaryRepo.findByAccount(accountinfo));
        modelAndView.addObject("trTypelist", typeRepo.findAll());
        modelAndView.addObject("obj", new TransactionDetails());
        modelAndView.setViewName("tr-details/tr");
        return modelAndView;
    }
//    @PostMapping(value = "/tr.jsf")
//    public ModelAndView save(@Valid TransactionDetails obj, BindingResult result, @RequestParam("accountNumber") long accountNo) {
//        ModelAndView modelAndView = new ModelAndView();
//        Account account = accountRepo.findByAccountNumber(accountNo);
//        if (obj == null) {
//            TransactionSummary summary = summaryRepo.findByAccount(account);
//            summary.setAccount(account);
//            summary.setBlanceAmount(obj.getPrimaryDepositAmount());
//            summary.setDepositAmount(obj.getPrimaryDepositAmount());
//            summary.setLastUpdate(new Date());
//            summaryRepo.save(summary);
//
//            TransactionDetails transactionDetails = new TransactionDetails();
//            transactionDetails.setAccount(account);
//            transactionDetails.setDepositAmount(obj.getPrimaryDepositAmount());
//            TransactionType ty = new TransactionType();
//            ty.setTypeName("deposit");
//            transactionDetails.setTransactionType(ty);
//            transactionDetails.setTransDate(new Date());
//            detailsRepo.save(transactionDetails);
//
//            modelAndView.addObject("successMsg", "Save Success");
//            modelAndView.addObject("obj", new Account());
//            modelAndView.addObject("accounttypelist", accountTypeRepo.findAll());
//            modelAndView.addObject("nomnieelist", nomineeRepo.findAll());
//            modelAndView.setViewName("accounts/create");
//        }
//        modelAndView.setViewName("accounts/create");
//        return modelAndView;
//    }

//    @GetMapping(value = "list.jsf")
//    public ModelAndView getList() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("list", repo.findAll());
//        modelAndView.setViewName("accounts/list");
//        return modelAndView;
//    }


}
