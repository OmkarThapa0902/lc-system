package com.letterofcredit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letterofcredit.entity.LetterOfCredit;

public interface LetterOfCreditRepository extends JpaRepository<LetterOfCredit, Long> {
}
