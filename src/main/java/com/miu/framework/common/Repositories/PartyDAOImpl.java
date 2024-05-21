package com.miu.framework.common.Repositories;

import com.miu.framework.common.entity.Party;

public class PartyDAOImpl extends PartyDAO{
    @Override
    void saveParty(Party party) {
        this.parties.add(party);
    }
}
