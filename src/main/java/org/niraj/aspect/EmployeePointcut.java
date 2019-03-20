package org.niraj.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class EmployeePointcut {

	@Pointcut("execution( String org.niraj.dao.AppDAOImpl.updateEmployee(..))")
	public void trackUpdateEmployee(){}
		
	@Pointcut("execution( String org.niraj.dao.AppDAOImpl.deleteEmployee(..))")
	public void trackDeleteEmployee(){}

}
