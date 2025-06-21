package com.fraudnexus.service;

import com.fraudnexus.dto.TransactionRequest;
import com.fraudnexus.entity.Transaction;
import com.fraudnexus.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public String createTransaction(TransactionRequest request) {
        // Simple rule-based fraud detection
        boolean isFraud = request.getAmount().compareTo(new java.math.BigDecimal("10000")) > 0;

        Transaction txn = new Transaction();
        txn.setCustomerId(request.getCustomerId());
        txn.setAmount(request.getAmount());
        txn.setDescription(request.getDescription());
        txn.setTimestamp(LocalDateTime.now());
        txn.setFraudulent(isFraud);

        transactionRepository.save(txn);

        return isFraud
                ? "🚨 Fraud Detected! Transaction saved and flagged."
                : "✅ Transaction saved successfully.";
    }
}
