package com.letterofcredit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.letterofcredit.entity.LetterOfCredit;

// Repository interface to perform CRUD operations on LetterOfCredit entities
public interface LetterOfCreditRepository extends JpaRepository<LetterOfCredit, Long> {
    // repository automatically provides basic methods like save, findById, findAll, and delete
}
