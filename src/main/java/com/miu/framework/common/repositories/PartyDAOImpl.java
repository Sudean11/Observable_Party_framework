package com.miu.framework.common.repositories;

import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class PartyDAOImpl implements PartyDAO {
    List<Party> parties = new ArrayList<>();
    private volatile static PartyDAOImpl instance;
    public static PartyDAOImpl getPartyDAO(){
        if(Objects.isNull(instance)){
            synchronized (PartyDAOImpl.class){
                if(Objects.isNull(instance)){
                    instance = new PartyDAOImpl();
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
            parties.remove(Partyexist); // remove the old
            parties.add(party); // add the new
        }
    };
    public Party loadParty(String partyEmail){
        for (Party party : parties) {
            if (party.getEmail().equals(partyEmail)) {
                return party;
            }
        }
        return null;
    };
    public Collection<Party> getParties(){
        return parties;
    }

    @Override
    public void saveParty(Party party) {
        parties.add(party);
    }
    public void removeParty(Party party){
        parties.remove(party);
    }
}
