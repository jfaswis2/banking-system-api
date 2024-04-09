package com.jfaswis2.bankingsystemapi.model.accounts;

import com.jfaswis2.bankingsystemapi.model.users.AccountHolder;
import com.jfaswis2.bankingsystemapi.util.Money;
import com.jfaswis2.bankingsystemapi.util.Status;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public abstract class Account {
    @JoinColumn(name = "balance")
    private BigDecimal balance;
    @JoinColumn(name = "secret_key")
    private short secretKey;
    @JoinColumn(name = "penalty_fee")
    private BigDecimal penaltyFee;
    @JoinColumn(name = "creation_date")
    private LocalDate creationDate;
    @JoinColumn(name = "status")
    private Status status;
}
