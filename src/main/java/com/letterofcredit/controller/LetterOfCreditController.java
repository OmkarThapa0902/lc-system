package com.letterofcredit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.letterofcredit.entity.LetterOfCredit;
import com.letterofcredit.service.LetterOfCreditService;

import java.util.List;

@RestController
@RequestMapping("/api/lettersOfCredit")
public class LetterOfCreditController {

    @Autowired
    private LetterOfCreditService letterOfCreditService;

    // Get all Letters of Credit
    @GetMapping
    public List<LetterOfCredit> getAllLettersOfCredit() {
        return letterOfCreditService.getAllLettersOfCredit();
    }

    // Get a specific Letter of Credit by ID
    @GetMapping("/{id}")
    public ResponseEntity<LetterOfCredit> getLetterOfCreditById(@PathVariable Long id) {
        return letterOfCreditService.getLetterOfCreditById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Letter of Credit
    @PostMapping
    public ResponseEntity<LetterOfCredit> createLetterOfCredit(@RequestBody LetterOfCredit letterOfCredit) {
        LetterOfCredit createdLC = letterOfCreditService.createLetterOfCredit(letterOfCredit);
        return ResponseEntity.ok(createdLC);
    }

    // Update an existing Letter of Credit
    @PutMapping("/{id}")
    public ResponseEntity<LetterOfCredit> updateLetterOfCredit(@PathVariable Long id, @RequestBody LetterOfCredit letterOfCredit) {
        try {
            LetterOfCredit updatedLC = letterOfCreditService.updateLetterOfCredit(id, letterOfCredit);
            return ResponseEntity.ok(updatedLC);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Letter of Credit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLetterOfCredit(@PathVariable Long id) {
        letterOfCreditService.deleteLetterOfCredit(id);
        return ResponseEntity.noContent().build();
    }
}
