package com.example.springbootoopproject.controller;

import com.example.springbootoopproject.model.Transaction;
import com.example.springbootoopproject.service.TransactionService;

import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<Transaction>>> getTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        Map<String, List<Transaction>> response = new HashMap<>();
        response.put("data", transactions);
        return ResponseEntity.ok(response);
    }
}