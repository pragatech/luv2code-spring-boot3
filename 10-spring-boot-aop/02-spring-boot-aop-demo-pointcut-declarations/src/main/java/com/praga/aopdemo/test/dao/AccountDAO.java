package com.praga.aopdemo.test.dao;

import com.praga.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean valid);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
