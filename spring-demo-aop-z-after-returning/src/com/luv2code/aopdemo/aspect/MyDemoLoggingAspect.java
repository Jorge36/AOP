package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n========>>> result is: " + result);
		
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
		
		System.out.println("\n=======>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method:" + methodSig);
		
		// display method arguments
		
		
		// get args 
		Object[] args = joinPoint.getArgs();
		
		// loop through args
		for (Object tempArg: args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account account = (Account) tempArg;
				
				System.out.println("account name" + account.getName());
				System.out.println("account level" + account.getLevel());
				
			}
			
		}
		
		
	}
		
}
