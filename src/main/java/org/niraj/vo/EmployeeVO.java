package org.niraj.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeVO {

	private int employeeId;
	
	@NotNull
	@Size(min=5, max=20)
	private String employeeName;

	@NotNull
	private String email;

	@NotNull
    private String department;
	
	@NotNull
	@Size(min=10, max=10)
    private String mobile;
	
	@NotNull
	private String city;

	@NotNull
	@Min(value = 10000L)
	@Max(value = 90000L)
    private int salary;

	private String active;

	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", department=" + department + ", mobile=" + mobile + ", city=" + city + ", salary=" + salary
				+ ", active=" + active + "]";
	}
	
	
	
	
	
}
