package com.example.springbootoopproject.repository;

import com.example.springbootoopproject.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}