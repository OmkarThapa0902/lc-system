package com.letterofcredit.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letterofcredit.entity.LetterOfCredit;

@Repository
public interface LetterOfCreditRepository extends JpaRepository<LetterOfCredit, Long> {
}
