package com.coderbd.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_summary")
public class TransactionSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double blanceAmount;
    private double depositAmount;
    private double withdrewAmount;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBlanceAmount() {
        return blanceAmount;
    }

    public void setBlanceAmount(double blanceAmount) {
        this.blanceAmount = blanceAmount;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
