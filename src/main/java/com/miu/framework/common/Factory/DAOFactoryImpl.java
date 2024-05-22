package com.miu.framework.common.Factory;

import com.miu.framework.common.Repositories.*;

import javax.servlet.http.Part;
import java.util.Objects;

public class DAOFactoryImpl implements DAOFactory {
    private volatile static DAOFactoryImpl instance;
    public static DAOFactoryImpl getDAOService(){
        if(Objects.isNull(instance)){
            synchronized (DAOFactoryImpl.class){
                if(Objects.isNull(instance)){
                    instance = new DAOFactoryImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public AccountDAO createAccountDAO() {
        return AccountDAOImpl.getAccountDAO();
    }

    @Override
    public PartyDAO createPartyDAO() {
        return PartyDAOImpl.getPartyDAO();
    }

    @Override
    public AccountDAO createCreditCardAccountDAO() {
        return CreditCardDAOImpl.getPartyDAO();
    }

    @Override
    public PartyDAO createCreditCardPartyDAO() {
        return CreditCardPartyDAO.getPartyDAO();
    }
}
