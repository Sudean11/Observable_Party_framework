package com.miu.framework.common.Repositories;

import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreditCardPartyDAO implements PartyDAO{
    List<Party> creditParties = new ArrayList<>();

    public void  save(Party party){
        saveParty(party);
    };
    public void updateParty(Party party){
        Party Partyexist = loadParty(party.getEmail());
        if (Partyexist != null) {
            creditParties.remove(Partyexist); // remove the old
            creditParties.add(party); // add the new
        }
    };
    public Party loadParty(String partyEmail){
        for (Party party : creditParties) {
            if (party.getEmail().equals(partyEmail)) {
                return party;
            }
        }
        return null;
    };
    public Collection<Party> getParties(){
        return creditParties;
    }

    @Override
    public void saveParty(Party party) {
        creditParties.add(party);
    }
    public void removeParty(Party party){
        creditParties.remove(party);
    }
}
