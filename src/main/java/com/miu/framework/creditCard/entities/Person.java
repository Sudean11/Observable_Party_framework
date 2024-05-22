package com.miu.framework.creditCard.entities;

import com.miu.framework.common.entity.Party;
import com.miu.framework.creditCard.constants.AccountType;

public class Person extends Party {
    private String accountNumber;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String expDate;
    private AccountType bankAccountType;

    public Person(String accountNumber,
                  String clientName,
                  String street,
                  String city,
                  String state,
                  String zip,
                  String expDate,
                  String email,
                  AccountType bankAccountType) {
        super(clientName, email, accountNumber);
        this.accountNumber = accountNumber;
        this.name = clientName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.expDate = expDate;
        this.email = email;
        this.bankAccountType = bankAccountType;
    }
}
