package com.miu.observable_party_account.creditCard.entities;

import com.miu.observable_party_account.framework.entity.Party;
import com.miu.observable_party_account.framework.utils.enums.AccountType;

public class Person extends Party {
    private String accountNumber;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String expDate;
    private AccountType creditAccountType;

    public Person(String accountNumber,
                  String clientName,
                  String street,
                  String city,
                  String state,
                  String zip,
                  String expDate,
                  String email,
                  AccountType creditAccountType) {
        super(clientName, email, accountNumber);
        this.accountNumber = accountNumber;
        this.name = clientName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.expDate = expDate;
        this.email = email;
        this.creditAccountType = creditAccountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public AccountType getCreditAccountType() {
        return creditAccountType;
    }

    @Override
    public String getExpDate() {
        return expDate;
    }


    @Override
    public String getAccountOwnerType(){
        return ""+this.getClass().getSimpleName().charAt(0);
    }


}
