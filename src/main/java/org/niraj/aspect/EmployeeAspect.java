package org.niraj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.niraj.vo.EmployeeVO;

@Aspect
public class EmployeeAspect extends EmployeePointcut{

	private int  sleepTimeForUpdate;
	private String userRole;
	private int maxSalary;

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getSleepTimeForUpdate() {
		return sleepTimeForUpdate;
	}

	public void setSleepTimeForUpdate(int sleepTimeForUpdate) {
		this.sleepTimeForUpdate = sleepTimeForUpdate;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	
	
	
	@Before("trackUpdateEmployee()")
	public void updateToEmployeeBeforeAdvice(JoinPoint jp) {
		System.out.println("Before Updation of Employee Advice is running ==>");
		Object[] methodArg = jp.getArgs();
		System.out.println("Arguments in update method" + ((EmployeeVO) methodArg[0]).toString() + " --- "
				+ methodArg[1]);
	}

	
	
	@Before("trackUpdateEmployee()")
	public void updateToEmployeeBeforeAdvice2(JoinPoint jp) {
		System.out.println("Before Updation of Employee Advice 2 ==>");
		Object[] methodArg = jp.getArgs();
		
		Object targetObject = jp.getTarget();
		
		EmployeeVO empVo = (EmployeeVO) methodArg[0];
		if ((empVo.getSalary() > maxSalary)) {
			System.out.println("Oh My God , Employee Salary Update is greater than "+ maxSalary);
			System.out.println("Sending mail to HR Head for further verification =================>");
		}

	}

	
	
	@AfterReturning("trackUpdateEmployee()")
	public void updateToEmployeeAfterAdvice(JoinPoint jp) {
		System.out.println("After Updation of Employee Advice is running ==>");
	}

	
	
	@Before("trackDeleteEmployee()")
	public void deleteEmployeeBeforeAdvice(JoinPoint jp) {
		System.out.println("Before Delete of Employee Advice is running ==>");
		Object[] methodArg = jp.getArgs();
		System.out.println("Arguments in delete method" + methodArg);

		try {
			System.out.println("Sleeping for [" + sleepTimeForUpdate
					+ "] seconds prior to delete || Calling some WebService ");
			Thread.sleep(sleepTimeForUpdate);
			System.out.println("Aftre Sleeping for [" + sleepTimeForUpdate
					+ "] seconds prior to delete || SMS sent to  [" + userRole + "]  ==> ");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Around("execution( * org.niraj.dao.AppDAOImpl.insertEmployee2(..))")
	public Object employeeNotAddedWhenCityIsDelhi( ProceedingJoinPoint pjp ) throws Throwable{
		System.out.println("In the Around Advice ====>");
		EmployeeVO empVo = (EmployeeVO)((pjp.getArgs())[0]);
		
		if(empVo.getCity().equalsIgnoreCase("Delhi")){
		System.out.println("City in new employee is " + empVo.getCity());
			return null;
		}
		System.out.println("City in new employee is " + empVo.getCity());
	   return pjp.proceed();
	}
	
	

	
	
	
	
	
}
