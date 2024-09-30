package com.letterofcredit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letterofcredit.entity.LetterOfCredit;
import com.letterofcredit.repository.LetterOfCreditRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LetterOfCreditService {

    @Autowired
    private LetterOfCreditRepository letterOfCreditRepository;

    // Get all Letters of Credit
    public List<LetterOfCredit> getAllLettersOfCredit() {
        return letterOfCreditRepository.findAll();
    }

    // Get a Letter of Credit by ID
    public Optional<LetterOfCredit> getLetterOfCreditById(Long id) {
        return letterOfCreditRepository.findById(id);
    }

    // Save a new Letter of Credit
    public LetterOfCredit createLetterOfCredit(LetterOfCredit letterOfCredit) {
        return letterOfCreditRepository.save(letterOfCredit);
    }

    // Update an existing Letter of Credit
    public LetterOfCredit updateLetterOfCredit(Long id, LetterOfCredit updatedLC) {
        return letterOfCreditRepository.findById(id).map(letterOfCredit -> {
            letterOfCredit.setApplicant(updatedLC.getApplicant());
            letterOfCredit.setBeneficiary(updatedLC.getBeneficiary());
            letterOfCredit.setProduct(updatedLC.getProduct());
            letterOfCredit.setIssueDate(updatedLC.getIssueDate());
            letterOfCredit.setDueDate(updatedLC.getDueDate());
            letterOfCredit.setStatus(updatedLC.getStatus());
            return letterOfCreditRepository.save(letterOfCredit);
        }).orElseThrow(() -> new IllegalArgumentException("Letter of Credit not found"));
    }

    // Delete a Letter of Credit
    public void deleteLetterOfCredit(Long id) {
        letterOfCreditRepository.deleteById(id);
    }
}

