package com.miu.observable_party_account.bank.entities;

import com.miu.observable_party_account.framework.utils.enums.BankAccountType;
import com.miu.observable_party_account.framework.entity.Party;

public class Company extends Party {
    private String accountNumber;
    private String street;
    private String city;
    private String state;
    private String zip;
    private int numberOfEmployees;
    private BankAccountType bankAccountType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public Company(String accountNumber,
                   String clientName,
                   String street,
                   String city,
                   String state,
                   String zip,
                   int numberOfEmployees,
                   String email,
                   BankAccountType bankAccountType) {
        super(clientName, email, accountNumber);
        this.accountNumber = accountNumber;
        this.name = clientName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.numberOfEmployees = numberOfEmployees;
        this.email = email;
        this.bankAccountType = bankAccountType;

    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getAccountType(){
        return ""+bankAccountType.toString().charAt(0);
    }

    @Override
    public String getAccountOwnerType(){
        return ""+this.getClass().getSimpleName().charAt(0);
    }
}
