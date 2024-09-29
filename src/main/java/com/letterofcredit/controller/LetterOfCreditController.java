package com.letterofcredit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.letterofcredit.entity.LetterOfCredit;
import com.letterofcredit.service.LetterOfCreditService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lcs")
@CrossOrigin("*") // Allows frontend calls from any origin
public class LetterOfCreditController {

    @Autowired
    private LetterOfCreditService service; // Injects the service layer to handle business logic

    // GET endpoint to retrieve all letters of credit
    @GetMapping
    public List<LetterOfCredit> getAllLCs() {
        // Calls service to fetch all letters of credit from the database
        return service.getAllLCs();
    }

    // GET endpoint to retrieve a specific letter of credit by ID
    @GetMapping("/{id}")
    public ResponseEntity<LetterOfCredit> getLCById(@PathVariable Long id) {
        // Calls service to fetch a letter of credit by its ID
        Optional<LetterOfCredit> lc = service.getLCById(id);
        // Returns the found LC with a 200 status, or 404 if not found
        return lc.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST endpoint to create a new letter of credit
    @PostMapping
    public LetterOfCredit createLC(@RequestBody LetterOfCredit lc) {
        // Calls service to save the new letter of credit in the database
        return service.createLC(lc);
    }

    // DELETE endpoint to remove a letter of credit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLC(@PathVariable Long id) {
        // Calls service to delete the letter of credit by ID
        service.deleteLC(id);
        // Returns 204 No Content on successful deletion
        return ResponseEntity.noContent().build();
    }
}
