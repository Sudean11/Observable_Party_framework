package com.miu.framework.common.Repositories;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.Collection;

public abstract class PartyDAO {
    ArrayList<Party> parties;
    public void  save(Party party){
        saveParty(party);
    };
    public void updateParty(Party party){
//		Party Partyexist = loadParty(Party.getEmail);
//		if (Partyexist != null) {
//			parties.remove(Partyexist); // remove the old
//			parties.add(party); // add the new
//		}
    };
    public Account loadParty(String partyEmail){
//		for (Party party : parties) {
//			if (party.getEmail().equals( partyEmail)) {
//				return party;
//			}
//		}
        return null;
    };
    public Collection<Party> getParties(){
        return parties;
    };
    abstract void saveParty(Party party);
    public void removeParty(Party party){
        parties.remove(party);
    }
}