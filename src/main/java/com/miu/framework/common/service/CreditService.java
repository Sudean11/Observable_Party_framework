package com.miu.framework.common.service;

import com.miu.framework.bank.observer.Observable;
import com.miu.framework.bank.observer.Observer;
import com.miu.framework.common.entity.Account;
import com.miu.framework.creditCard.Factory.AccountDAOAndServiceFactory;
import com.miu.framework.creditCard.Factory.AccountDAOServiceImpl;
import com.miu.framework.creditCard.Repositories.AccountDAO;
import com.miu.framework.creditCard.Repositories.AccountDAOImpl;

import java.util.List;

public class CreditService implements AccountService, Observable {
    @Override
    public void createAccount() {

    }

    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }

    @Override
    public void report() {

    }

    @Override
    public void addInterest() {
        AccountDAOAndServiceFactory accountDao = new AccountDAOServiceImpl();
        AccountDAO accountDAO = accountDao.createAccountDAO();
        List<Account> accounts = accountDAO.getAccounts();
        for(Account account: accounts){
            account.withdraw(account.calculateInterest(account.getBalance()));
        }
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(String email, String message) {

    }
}
