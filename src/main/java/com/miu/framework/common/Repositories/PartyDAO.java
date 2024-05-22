package com.miu.framework.common.Repositories;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface PartyDAO {
    public void updateParty(Party party);
    public Party loadParty(String partyEmail);
    public Collection<Party> getParties();


    abstract void saveParty(Party party);
    public void removeParty(Party party);
}