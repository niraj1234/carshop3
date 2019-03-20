package org.niraj.junit1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTestCase {

	EmpBusinessLogic empBusinessLogic =new EmpBusinessLogic();
	EmployeeDetails employee = new EmployeeDetails();
	
	@Test
	public void testEmployeeYearlySalary(){
		
		employee.setName("Rajan");
		employee.setAge(29);
		employee.setMonthlySalary(8000);
		
		double salary = empBusinessLogic.calculateYearlySalary(employee);
		assertEquals(96000 , salary , 0.0);
	}
	
	@Test
	   public void testCalculateAppriasal() {
	      employee.setName("Rajeev");
	      employee.setAge(25);
	      employee.setMonthlySalary(8000);
	      double appraisal= empBusinessLogic.calculateAppraisal(employee);
	      assertEquals(500, appraisal, 0.0);
	   }
}
