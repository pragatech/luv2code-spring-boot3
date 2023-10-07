package com.praga.aopdemo.test.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": Doing my DB Work: Adding an Account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": Doing my DB Work: go to sleep");
    }
}
