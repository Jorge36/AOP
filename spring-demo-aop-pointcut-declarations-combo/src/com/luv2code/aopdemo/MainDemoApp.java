package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get the membership bean from spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);		
		
		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
		// call the business membership method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		/*
		
		// do it again!
		System.out.println("\n let's call it again!\n");
		
		// call the business method again
		accountDAO.addAccount();
		// call the business membership method
		membershipDAO.addSillyMember(); */
		
		// close the context
		context.close();
		
	}

}
