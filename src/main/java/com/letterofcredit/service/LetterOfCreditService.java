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
    private LetterOfCreditRepository repository;

    public List<LetterOfCredit> getAllLCs() {
        return repository.findAll();
    }

    public Optional<LetterOfCredit> getLCById(Long id) {
        return repository.findById(id);
    }

    public LetterOfCredit createLC(LetterOfCredit lc) {
        return repository.save(lc);
    }

    public void deleteLC(Long id) {
        repository.deleteById(id);
    }
}
