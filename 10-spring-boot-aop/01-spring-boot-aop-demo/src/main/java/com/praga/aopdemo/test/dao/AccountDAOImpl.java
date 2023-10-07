package com.praga.aopdemo.test.dao;

import com.praga.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account account, boolean v) {
        System.out.println(getClass() + ": Doing my DB Work: Adding an Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": Doing my DB Work: Do work");
        return false;
    }
}
