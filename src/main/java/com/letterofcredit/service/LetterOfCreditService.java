package com.letterofcredit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letterofcredit.entity.LetterOfCredit;
import com.letterofcredit.repository.LetterOfCreditRepository;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a service layer component
public class LetterOfCreditService {

    @Autowired
    private LetterOfCreditRepository repository; // Injects the repository to interact with the database

    // Fetches all letters of credit
    public List<LetterOfCredit> getAllLCs() {
        return repository.findAll();
    }

    // Fetches a specific letter of credit by ID
    public Optional<LetterOfCredit> getLCById(Long id) {
        return repository.findById(id);
    }

    // Creates a new letter of credit
    public LetterOfCredit createLC(LetterOfCredit lc) {
        return repository.save(lc);
    }

    // Deletes a letter of credit by ID
    public void deleteLC(Long id) {
        repository.deleteById(id);
    }
}
