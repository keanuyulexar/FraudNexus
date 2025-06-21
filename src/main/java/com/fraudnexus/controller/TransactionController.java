package com.fraudnexus.controller;


import com.fraudnexus.dto.TransactionRequest;
import com.fraudnexus.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public String createTransaction(@RequestBody TransactionRequest request) {
        return transactionService.createTransaction(request);
    }
}
