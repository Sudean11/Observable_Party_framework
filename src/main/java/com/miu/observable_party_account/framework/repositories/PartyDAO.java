package com.miu.observable_party_account.framework.repositories;

import com.miu.observable_party_account.framework.entity.Party;

import java.util.Collection;

public interface PartyDAO {
    public void updateParty(Party party);
    public Party loadParty(String partyEmail);
    public Collection<Party> getParties();


    abstract void saveParty(Party party);
    public void removeParty(Party party);
}