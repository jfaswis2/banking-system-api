package com.jfaswis2.bankingsystemapi.model.users;

import com.jfaswis2.bankingsystemapi.model.accounts.Checking;
import com.jfaswis2.bankingsystemapi.model.accounts.CreditCard;
import com.jfaswis2.bankingsystemapi.model.accounts.Savings;
import com.jfaswis2.bankingsystemapi.model.accounts.StudentChecking;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfBirth;
    @OneToOne
    @JoinColumn(name = "primary_address_id")
    private Address primaryAddress;

    @OneToMany
    @JoinColumn(name = "account_holder_id")
    private Set<Address> mailingAddress;

    @OneToMany(mappedBy = "primaryOwner", cascade = CascadeType.ALL)
    private Set<Checking> checkingPrimaryAccounts;

    @OneToMany(mappedBy = "secondaryOwner", cascade = CascadeType.ALL)
    private Set<Checking> checkingSecondaryAccounts;

    @OneToMany(mappedBy = "primaryOwner", cascade = CascadeType.ALL)
    private Set<CreditCard> creditCardPrimaryAccounts;

    @OneToMany(mappedBy = "secondaryOwner", cascade = CascadeType.ALL)
    private Set<CreditCard> creditCardSecondaryAccounts;

    @OneToMany(mappedBy = "primaryOwner", cascade = CascadeType.ALL)
    private Set<Savings> savingsPrimaryAccounts;

    @OneToMany(mappedBy = "secondaryOwner", cascade = CascadeType.ALL)
    private Set<Savings> savingsSecondaryAccounts;

    @OneToMany(mappedBy = "primaryOwner", cascade = CascadeType.ALL)
    private Set<StudentChecking> studentCheckingPrimaryAccounts;

    @OneToMany(mappedBy = "secondaryOwner", cascade = CascadeType.ALL)
    private Set<StudentChecking> studentCheckingSecondaryAccounts;
}
