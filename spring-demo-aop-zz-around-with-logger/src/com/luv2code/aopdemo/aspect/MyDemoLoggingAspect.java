package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = proceedingJoinPoint.proceed();
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n========>>> Duration: " + duration / 1000.0 + "seconds");

		return result;
		
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n========>>> Executing @After (finally) on method: " + method);
		
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n========>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n========>>> The exception is: " + theExc);
		
	}
	
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n========>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n========>>> result is: " + result);
		
		// let's post-process the data ... let's modify it
		
		// convert the account names to UPPERCASE
		convertAccountNameToUpperCase(result);

		
	}
	

	private void convertAccountNameToUpperCase(List<Account> result) {
		
		String name;
		
		for (Account account: result) {
			
			name = account.getName().toUpperCase();
			account.setName(name);
			
		}
		
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		myLogger.info("\n=======>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		
		myLogger.info("Method:" + methodSig);
		
		// display method arguments
		
		
		// get args 
		Object[] args = joinPoint.getArgs();
		
		// loop through args
		for (Object tempArg: args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account account = (Account) tempArg;
				
				myLogger.info("account name" + account.getName());
				myLogger.info("account level" + account.getLevel());
				
			}
			
		}
		
		
	}
		
}
