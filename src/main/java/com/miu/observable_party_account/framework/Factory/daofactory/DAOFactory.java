package com.miu.observable_party_account.framework.Factory.daofactory;

import com.miu.observable_party_account.framework.repositories.AccountDAO;
import com.miu.observable_party_account.framework.repositories.PartyDAO;

public interface DAOFactory {
    AccountDAO createAccountDAO();
    PartyDAO createPartyDAO();


}
