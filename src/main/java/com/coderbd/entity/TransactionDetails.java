package com.coderbd.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double depositAmount;
    private double withdrewAmount;
    private double blanceAmount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "tr_type_id")
    private TransactionType transactionType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getWithdrewAmount() {
        return withdrewAmount;
    }

    public void setWithdrewAmount(double withdrewAmount) {
        this.withdrewAmount = withdrewAmount;
    }

    public double getBlanceAmount() {
        return blanceAmount;
    }

    public void setBlanceAmount(double blanceAmount) {
        this.blanceAmount = blanceAmount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }


}
