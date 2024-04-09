package com.jfaswis2.bankingsystemapi.model.accounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jfaswis2.bankingsystemapi.model.users.AccountHolder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class StudentChecking extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    @JsonIgnore
    private AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    @JsonIgnore
    private AccountHolder secondaryOwner;
}
