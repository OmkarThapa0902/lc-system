package com.letterofcredit.entity;

//Entity class representing the Letter of Credit (LC)


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
public class LetterOfCredit {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
 private Long id;

 @ManyToOne  // Many Letters of Credit can belong to one Applicant
 @JoinColumn(name = "applicant_id")  // Foreign key reference to Applicant
 private Applicant applicant;

 @ManyToOne  // Many Letters of Credit can belong to one Beneficiary
 @JoinColumn(name = "beneficiary_id")  // Foreign key reference to Beneficiary
 private Beneficiary beneficiary;

 @ManyToOne  // Many Letters of Credit can involve one Product
 @JoinColumn(name = "product_id")  // Foreign key reference to Product
 private Product product;

 @Temporal(TemporalType.DATE)  // Specify the date format for issue date
 private Date issueDate;

 @Temporal(TemporalType.DATE)  // Specify the date format for due date
 private Date dueDate;

 @NotBlank(message = "Status is mandatory")  // Validation: Status cannot be blank
 private String status;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Applicant getApplicant() {
	return applicant;
}

public void setApplicant(Applicant applicant) {
	this.applicant = applicant;
}

public Beneficiary getBeneficiary() {
	return beneficiary;
}

public void setBeneficiary(Beneficiary beneficiary) {
	this.beneficiary = beneficiary;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public Date getIssueDate() {
	return issueDate;
}

public void setIssueDate(Date issueDate) {
	this.issueDate = issueDate;
}

public Date getDueDate() {
	return dueDate;
}

public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}


 
}
