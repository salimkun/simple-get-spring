package com.example.springbootoopproject.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trx")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id") // Sesuaikan dengan nama kolom di database
    private String productID;

    @Column(name = "product_name") // Sesuaikan dengan nama kolom di database
    private String productName;

    @Column(name = "amount") // Sesuaikan dengan nama kolom di database
    private Double amount;

    @Column(name = "customer_name") // Sesuaikan dengan nama kolom di database
    private String customerName;

    @Column(name = "status") // Sesuaikan dengan nama kolom di database
    private Integer status;

    @Column(name = "transaction_date") // Sesuaikan dengan nama kolom di database
    private LocalDateTime transactionDate;

    @Column(name = "create_by") // Sesuaikan dengan nama kolom di database
    private String createBy;

    @Column(name = "create_on") // Sesuaikan dengan nama kolom di database
    private LocalDateTime createOn;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }
}