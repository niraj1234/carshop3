package org.niraj.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {	

	@Pointcut("execution(* org.niraj.action.EmployeeAction.*(..) )")
	public void allMethodsPC(){}
	
	@Before("allMethodsPC()")
	public void printNameToMethodAdvice(JoinPoint jp){
		System.out.println("Method name in Aspect ===> " + jp.getSignature() + " At time  "+ new Date() );
	}
}
