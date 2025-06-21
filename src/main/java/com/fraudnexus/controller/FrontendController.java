package com.fraudnexus.controller;

import com.fraudnexus.dto.TransactionRequest;
import com.fraudnexus.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontendController {

    private final TransactionService transactionService;

    public FrontendController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("transactionRequest", new TransactionRequest());
        return "transactionsForm";
    }
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("TransactionRequest") TransactionRequest transactionRequest, Model model) {
        String result = transactionService.createTransaction(transactionRequest);
        model.addAttribute("result", result);
        return "result";
    }
}
