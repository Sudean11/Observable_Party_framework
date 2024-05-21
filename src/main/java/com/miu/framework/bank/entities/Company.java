package com.miu.framework.bank.entities;

import com.miu.framework.common.entity.Party;

public class Company extends Party {
    private String companyName;

    public Company(String id, String companyName, String email) {
        super(id, companyName, email);
        this.companyName = companyName;
    }
}
