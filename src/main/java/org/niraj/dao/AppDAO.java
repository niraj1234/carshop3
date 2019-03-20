package org.niraj.dao;

import java.util.List;

import org.niraj.vo.CompanyUserVO;
import org.niraj.vo.CompanyVO;
import org.niraj.vo.EmployeeVO;

public interface AppDAO {
	public List<EmployeeVO> getAllEmployee();
	public String getEmployeeByName(String empName);
	public EmployeeVO insertEmployee(EmployeeVO empVo);
	public String updateEmployee(EmployeeVO empVo , int empId);
	public EmployeeVO getEmployee(int empId);
	public EmployeeVO insertEmployee2(final EmployeeVO empVo);
	public String deleteEmployee(int empId);
	public String insertCompany(CompanyVO companyVo);
	public CompanyUserVO getCompanyUser(String userName);
	public List<CompanyVO> getCompanyByUser(int userId);
	public List<CompanyVO> getAllCompany();
}
