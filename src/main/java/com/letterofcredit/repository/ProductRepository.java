package com.letterofcredit.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letterofcredit.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
