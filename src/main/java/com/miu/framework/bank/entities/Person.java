package com.miu.framework.bank.entities;

import com.miu.framework.common.utils.enums.BankAccountType;
import com.miu.framework.common.entity.Party;

public class Person extends Party {
    private String accountNumber;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String dob;
    private BankAccountType bankAccountType;

    public Person(String accountNumber,
                  String clientName,
                  String street,
                  String city,
                  String state,
                  String zip,
                  String dob,
                  String email,
                  BankAccountType bankAccountType) {
        super(clientName, email, accountNumber);
        this.accountNumber = accountNumber;
        this.name = clientName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.dob = dob;
        this.email = email;
        this.bankAccountType = bankAccountType;
    }

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

    public String getDob() {
        return dob;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
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
