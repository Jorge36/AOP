package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	// this s where we add all of our related advices for logging
	
	
	// let's start with and @Before advice
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forGetterMethod() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forSetterMethod() {}	
	
	@Pointcut("forDaoPackage() && !(forGetterMethod() || forSetterMethod())")
	public void forDaoPackageNoGetterSetter() {}
	
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(void add*())")
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	//@Before("execution(* add*(..))")
	//@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	//@Before("forDaoPackage()")
}
