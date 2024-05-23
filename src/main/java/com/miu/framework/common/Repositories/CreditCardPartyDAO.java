package com.miu.framework.common.Repositories;

import com.miu.framework.common.Repositories.storage.DataAccessFacade;
import com.miu.framework.common.Repositories.storage.StorageType;
import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CreditCardPartyDAO implements PartyDAO{
    private static volatile CreditCardPartyDAO instance;
    private DataAccessFacade dataAccess;

    private CreditCardPartyDAO() {
        dataAccess = new DataAccessFacade();
    }

    public static CreditCardPartyDAO getPartyDAO() {
        if (instance == null) {
            synchronized (PartyDAOImpl.class) {
                if (instance == null) {
                    instance = new CreditCardPartyDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void saveParty(Party party) {
        dataAccess.save(party, party.getEmail(), StorageType.PARTIES);
    }

    @Override
    public void removeParty(Party party) {
        dataAccess.remove(party.getEmail(), StorageType.PARTIES);
    }

    @Override
    public Party loadParty(String partyEmail) {
        return dataAccess.load(partyEmail, StorageType.PARTIES);
    }

    @Override
    public List<Party> getParties() {
        return dataAccess.getAll(StorageType.PARTIES);
    }

    public void updateParty(Party party) {
        dataAccess.update(party, party.getEmail(), StorageType.PARTIES);
    }
}
