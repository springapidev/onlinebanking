package com.coderbd.repo;

import com.coderbd.entity.Account;
import com.coderbd.entity.TransactionSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionSummaryRepo extends JpaRepository<TransactionSummary, Long> {
    TransactionSummary findByAccount(Account account);

}
