package com.miu.framework.common.Factory.daofactory;

import com.miu.framework.common.repositories.AccountDAO;
import com.miu.framework.common.repositories.PartyDAO;

public interface DAOFactory {
    AccountDAO createAccountDAO();
    PartyDAO createPartyDAO();


}
