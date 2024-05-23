package com.miu.framework.common.repositories;

import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CreditCardPartyDAO implements PartyDAO{
    List<Party> creditParties = new ArrayList<>();

    private volatile static CreditCardPartyDAO instance;

    public static CreditCardPartyDAO getPartyDAO(){
        if(Objects.isNull(instance)){
            synchronized (CreditCardPartyDAO.class){
                if(Objects.isNull(instance)){
                    instance = new CreditCardPartyDAO();
                }
            }
        }
        return instance;
    }
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
