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
@CrossOrigin("*") // Allow frontend calls
public class LetterOfCreditController {

    @Autowired
    private LetterOfCreditService service;

    @GetMapping
    public List<LetterOfCredit> getAllLCs() {
        return service.getAllLCs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetterOfCredit> getLCById(@PathVariable Long id) {
        Optional<LetterOfCredit> lc = service.getLCById(id);
        return lc.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public LetterOfCredit createLC(@RequestBody LetterOfCredit lc) {
        return service.createLC(lc);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLC(@PathVariable Long id) {
        service.deleteLC(id);
        return ResponseEntity.noContent().build();
    }
}
