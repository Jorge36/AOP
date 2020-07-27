package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this s where we add all of our related advices for logging
	
	
	// let's start with and @Before advice
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forGetterMethod() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forSetterMethod() {}	
	
	@Pointcut("forDaoPackage() && !(forGetterMethod() || forSetterMethod())")
	private void forDaoPackageNoGetterSetter() {}
	
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(void add*())")
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	//@Before("execution(* add*(..))")
	//@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	//@Before("forDaoPackage()")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======>> Executing @Before advice on addAccount()");
		
	}
	
	//@Before("forDaoPackage()")
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n=======>> Performing API analytics");
		
	}
	

}
