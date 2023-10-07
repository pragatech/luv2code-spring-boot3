package com.praga.aopdemo.test.dao;

import com.praga.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ":Do getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ":Do setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ":Do getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ":Do setServiceCode");
        this.serviceCode = serviceCode;
    }

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
