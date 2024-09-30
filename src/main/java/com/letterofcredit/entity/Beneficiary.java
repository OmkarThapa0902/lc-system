package com.letterofcredit.entity;

//Entity class representing the Beneficiary (Seller)

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Beneficiary {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
 private Long id;

 @NotBlank(message = "Account number is mandatory")  // Validation: Private account number
 private String accountNumber;

 @OneToMany(mappedBy = "beneficiary")  // One Beneficiary can have many Letters of Credit
 private List<LetterOfCredit> lettersOfCredit;

 
 
 // Getters and Setters 
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public List<LetterOfCredit> getLettersOfCredit() {
	return lettersOfCredit;
}

public void setLettersOfCredit(List<LetterOfCredit> lettersOfCredit) {
	this.lettersOfCredit = lettersOfCredit;
}


 
 
 
 
}
