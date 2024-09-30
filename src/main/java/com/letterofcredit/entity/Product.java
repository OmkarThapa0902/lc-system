package com.letterofcredit.entity;

//Entity class representing the Product


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.List;

@Entity
public class Product {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
 private Long id;

 @NotBlank(message = "Product name is mandatory")  // Validation: Product name cannot be blank
 private String productName;

 @Positive(message = "Quantity must be positive")  // Validation: Quantity must be positive
 private int quantity;

 @Positive(message = "Amount must be positive")  // Validation: Amount must be positive
 private double amount;

 @OneToMany(mappedBy = "product")  // One Product can have many Letters of Credit
 private List<LetterOfCredit> lettersOfCredit;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public List<LetterOfCredit> getLettersOfCredit() {
	return lettersOfCredit;
}

public void setLettersOfCredit(List<LetterOfCredit> lettersOfCredit) {
	this.lettersOfCredit = lettersOfCredit;
}


 
 
}
