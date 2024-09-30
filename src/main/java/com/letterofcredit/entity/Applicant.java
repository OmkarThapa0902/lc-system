package com.letterofcredit.entity;

// Entity class representing the Applicant (Buyer)

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
    private Long id;

    @NotBlank(message = "Account number is mandatory")  // Validation: Private account number
    private String accountNumber;

    @OneToMany(mappedBy = "applicant")  // One Applicant can have many Letters of Credit
    private List<LetterOfCredit> lettersOfCredit;

    
    // Getters and Setters (Omitted for brevity)
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

