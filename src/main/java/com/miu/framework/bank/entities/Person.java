package com.miu.framework.bank.entities;

import com.miu.framework.common.entity.Party;

public class Person extends Party {
    private String firstName;
    private String lastName;

    public Person(String id, String firstName, String lastName, String email) {
        super(id, firstName + " " + lastName, email);
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
