package com.praga.aopdemo;

import com.praga.aopdemo.test.dao.AccountDAO;
import com.praga.aopdemo.test.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class AopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){

        return runner -> {
            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);
            demoTheBeforeAdvice(accountDAO);
            callGetterAndSetter(accountDAO);
            demoTheBeforeAdvice(membershipDAO);
        };
    }

    private void callGetterAndSetter(AccountDAO accountDAO) {
        System.out.println("=======***********=======");
        accountDAO.setName("qwe");
        accountDAO.setServiceCode("ewree");

        accountDAO.getName();
        accountDAO.getServiceCode();
        System.out.println("=======***********=======");
    }

    private void demoTheBeforeAdvice(MembershipDAO membershipDAO) {
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO) {
        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();
    }

}
