package com.fraudnexus.repository;

import com.fraudnexus.entity.Transaction; // ✅ THIS IS CRITICAL!
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
