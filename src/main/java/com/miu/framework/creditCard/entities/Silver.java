package com.miu.framework.creditCard.entities;

import com.miu.framework.common.entity.Party;

public class Silver extends CreditAccount{

    public Silver(String accountNumber, Party owner) {
        super(accountNumber, owner);
    }
}
