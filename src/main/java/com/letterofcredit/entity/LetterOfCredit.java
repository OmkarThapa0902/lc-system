package com.letterofcredit.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity 
public class LetterOfCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String applicant;   // Buyer (Applicant in the LC)
    private String beneficiary; // Seller (Beneficiary in the LC)
    private Double amount;      // The amount of the LC
    private String currency;    // Currency of the LC
    private Date issueDate;     // Date the LC was issued
    private String status;      // Status of the LC (e.g., pending, approved, etc.)

    // Getters and setters for each field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
