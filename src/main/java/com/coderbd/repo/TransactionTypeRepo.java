package com.coderbd.repo;

import com.coderbd.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepo extends JpaRepository<TransactionType, Long> {
}
