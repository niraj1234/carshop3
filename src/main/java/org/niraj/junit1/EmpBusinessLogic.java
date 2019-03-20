package org.niraj.junit1;

public class EmpBusinessLogic {

	public double calculateYearlySalary(EmployeeDetails empDetail){
		double calculatedYearlySalary = 0;
		double salary = empDetail.getMonthlySalary();
		calculatedYearlySalary = salary*12;
		return calculatedYearlySalary;
	}

	
	 public double calculateAppraisal(EmployeeDetails employeeDetails){
	      double appraisal=0;
	      if(employeeDetails.getMonthlySalary() < 10000){
	         appraisal = 500;
	      }else{
	         appraisal = 1000;
	      }
	      return appraisal;
	   }
}
