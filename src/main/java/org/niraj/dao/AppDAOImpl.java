package org.niraj.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.niraj.vo.CompanyUserVO;
import org.niraj.vo.CompanyVO;
import org.niraj.vo.EmployeeVO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;


public class AppDAOImpl implements AppDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	private String insertKey ="KEY_INSERT"; 
	private String insertKeyCompany ="KEY_INSERT_COMPANY"; 
	
	public String getEmployeeByName(String empName) {
		return null;
	}
		

	
	
	public List<EmployeeVO> getAllEmployee() {
	  List<EmployeeVO> employeeList =  new ArrayList<EmployeeVO>();
	  String sqlQuery = "SELECT employeeId, employeeName, email, department, mobile, city, salary, active FROM employee_master order by employeeId DESC";
	    employeeList = jdbcTemplate.query(sqlQuery, new RowMapper<EmployeeVO>() {
			public EmployeeVO mapRow(ResultSet rs, int idx) throws SQLException {
				EmployeeVO empVo = new EmployeeVO();
				empVo.setEmployeeId(rs.getInt("employeeId"));
				empVo.setEmployeeName(rs.getString("employeeName"));
				empVo.setEmail(rs.getString("email"));
				empVo.setDepartment(rs.getString("department"));
				empVo.setMobile(rs.getString("mobile"));
				empVo.setCity(rs.getString("city"));
				empVo.setSalary(rs.getInt("salary"));
				empVo.setActive(rs.getString("active"));
				return empVo;
			}
		});
		return employeeList;
	}


	
	
	
	
	public EmployeeVO getEmployee(int empId) {
		  List<EmployeeVO> employeeList =  new ArrayList<EmployeeVO>();
          EmployeeVO empVoReturn = null;
          
		  String sqlQuery = "SELECT employeeId, employeeName, email, department, mobile, city, salary, active FROM employee_master where employeeId = ?";
		    employeeList = jdbcTemplate.query(sqlQuery, new Object[]{empId} ,new RowMapper<EmployeeVO>() {
				public EmployeeVO mapRow(ResultSet rs, int idx) throws SQLException {
					EmployeeVO empVo = new EmployeeVO();
					empVo.setEmployeeId(rs.getInt("employeeId"));
					empVo.setEmployeeName(rs.getString("employeeName"));
					empVo.setEmail(rs.getString("email"));
					empVo.setDepartment(rs.getString("department"));
					empVo.setMobile(rs.getString("mobile"));
					empVo.setCity(rs.getString("city"));
					empVo.setSalary(rs.getInt("salary"));
					empVo.setActive(rs.getString("active"));
					return empVo;
				}
			});

		    if(employeeList.size()>0){
		    	empVoReturn = new EmployeeVO();
		    	empVoReturn = employeeList.get(0);
		    }
			return empVoReturn;
		}

		

	
	
	
	
	
	public EmployeeVO insertEmployee(final EmployeeVO empVo) {
	   System.out.println("Insering Employee in DB ===> DONE"+empVo.toString());
	   String sqlString = "INSERT INTO employee_master (employeeName, email, department, mobile, city, salary, active)  VALUES (?, ?, ?, ?, ?, ?, ?)"; 
	   
	   EmployeeVO emp = jdbcTemplate.execute(sqlString, new PreparedStatementCallback<EmployeeVO>() {
		public EmployeeVO doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
			pstmt.setString(1, empVo.getEmployeeName());
			pstmt.setString(2, empVo.getEmail());
			pstmt.setString(3, empVo.getDepartment());
			pstmt.setString(4, empVo.getMobile());
			pstmt.setString(5, empVo.getCity());
			pstmt.setInt(6, empVo.getSalary());
			pstmt.setString(7, empVo.getActive());
			
			boolean result = pstmt.execute();
			System.out.println("Data Insert result ==> "+ result);			

			if(result == false){
            	System.out.println("Data Updated Successfully");
            }else if(result == true){
            	System.out.println("ResultSet returned");
            }else{
            	System.out.println("Result is no hence data not updated");
            }
			System.out.println("||||||"+ empVo.toString());
			return empVo;
		}
      });

	   return emp;
	}
	
	

	public EmployeeVO insertEmployee2(final EmployeeVO empVo) {
		   System.out.println("Insering Employee in DB ===> DONE"+empVo.toString());
		   String sqlString = "INSERT INTO employee_master (employeeName, email, department, mobile, city, salary, active)  VALUES (?, ?, ?, ?, ?, ?, ?)"; 

		   int maxEmployeeId;
		   synchronized(insertKey){
		   int insertResult = jdbcTemplate.update(sqlString, empVo.getEmployeeName(), empVo.getEmail(),
				empVo.getDepartment(), empVo.getMobile(), empVo.getCity(), empVo.getSalary(), empVo.getActive());

		   if(insertResult>0){
        	   System.out.println("Insert Success in insertEmployee2 ==>");
           }else{
        	   System.out.println("Insert failed in insertEmployee2 ==>");
           }
           
           if(empVo.getEmployeeName().equalsIgnoreCase("Niraj")){
        	   try {
        		   System.out.println("In the Sleeping block as name is Niraj");
				   Thread.sleep(40000);
     		       System.out.println("Out from Sleeping block ==>");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
           }

           maxEmployeeId = jdbcTemplate.queryForInt("SELECT MAX(employeeId) FROM employee_master");
           System.out.println("Employee Id last inserted " + maxEmployeeId);
		    }

		   
/*           
		   EmployeeVO emp = jdbcTemplate.execute(sqlString, new PreparedStatementCallback<EmployeeVO>() {

			public EmployeeVO doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
			
				pstmt.setString(1, empVo.getEmployeeName());
				pstmt.setString(2, empVo.getEmail());
				pstmt.setString(3, empVo.getDepartment());
				pstmt.setString(4, empVo.getMobile());
				pstmt.setString(5, empVo.getCity());
				pstmt.setInt(6, empVo.getSalary());
				pstmt.setString(7, empVo.getActive());
				
				boolean result = pstmt.execute();
				System.out.println("Data Insert result ==> "+ result);			

				if(result == false){
	            	System.out.println("Data Updated Successfully");
	            }else if(result == true){
	            	System.out.println("ResultSet returned");
	            }else{
	            	System.out.println("Result is no hence data not updated");
	            }
				System.out.println("||||||"+ empVo.toString());
				return empVo;
			}
	      });

*/		   
           return empVo;
	}
				
		

	
	
	
	public String updateEmployee(EmployeeVO empVo , int empId) {
		String sqlQuery = "UPDATE employee_master SET employeeName = ? , email=?, department = ? , mobile = ? , city = ? , salary = ? , active = ?  WHERE employeeId = ? ";
        String dataUpdateStatus ="";
		
		int updateResult = jdbcTemplate.update(sqlQuery, empVo.getEmployeeName(), empVo.getEmail(),
				empVo.getDepartment(), empVo.getMobile(), empVo.getCity(), empVo.getSalary(), empVo.getActive(), empId);

	     if(updateResult>0){
	    	 System.out.println("Data Updated Successfully ");
	    	 dataUpdateStatus = "SUCCESS";
	     }else{
	    	 System.out.println("Data Updation Failed ");
	    	 dataUpdateStatus = "FAILED";
	     }
	     
	     return dataUpdateStatus;
	}
	
	
	
	
	public String deleteEmployee(int empId) {	
		String sqlQuery = "DELETE FROM employee_master WHERE employeeId = ? " ;
		int deleteResult = jdbcTemplate.update(sqlQuery, empId);
		String deleteStatus = "";
		
		if(deleteResult>0){
			deleteStatus="SUCCESS";
		}else{
			deleteStatus="FAILED";
		}
		return deleteStatus;
	}

	
	
	
	public CompanyUserVO getCompanyUser(String userName) {
		  List<CompanyUserVO> userList =  new ArrayList<CompanyUserVO>();
          CompanyUserVO companyUserVoReturn = null;

		String sqlQuery = "SELECT userId, userName, password, fullname, email, mobile, userRole, userStatus FROM company_users WHERE userName= ? ";

		    userList = jdbcTemplate.query(sqlQuery, new Object[]{userName} ,new RowMapper<CompanyUserVO>() {
				public CompanyUserVO mapRow(ResultSet rs, int idx) throws SQLException {
					CompanyUserVO companyUserVo = new CompanyUserVO();
						companyUserVo.setUserId(rs.getInt("userId"));
						companyUserVo.setUserName(rs.getString("userName"));
						companyUserVo.setPassword(rs.getString("password"));
						companyUserVo.setFullname(rs.getString("fullname"));
						companyUserVo.setEmail(rs.getString("email"));
						companyUserVo.setMobile(rs.getString("mobile"));
						companyUserVo.setUserRole(rs.getString("userRole"));
						companyUserVo.setUserStatus(rs.getString("userStatus"));
					return companyUserVo;
				}

			});

		    if(userList.size()>0){
		    	companyUserVoReturn = new CompanyUserVO();
		    	companyUserVoReturn = userList.get(0);
		    }

			return companyUserVoReturn;
		}

	
	
	
	public String insertCompany(CompanyVO companyVo) {

		String dbResult = "";	
		String sqlString = "INSERT INTO company_master ( companyName, businessCategory, yearOfCreation, founder, websiteAddress, "
				+ "city, contactEmail, noOfEmployees, contactNumber, fkCompanyUser )  "
				+ "VALUES ( ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ?  )";

		   synchronized(insertKeyCompany){
		   int insertResult = jdbcTemplate.update(sqlString, companyVo.getCompanyName(), companyVo.getBusinessCategory() , companyVo.getYearOfCreation() , companyVo.getFounder() , 
				   companyVo.getWebsiteAddress() , companyVo.getCity() , companyVo.getContactEmail() , companyVo.getNoOfEmployees() , companyVo.getContactNumber() , companyVo.getFkCompanyUseId() );
		   
			   if(insertResult>0){
		     	   System.out.println("Insert Success ==>");
		     	  dbResult = "DB_SUCCESS";
		  		  System.out.println("Insering Employee in DB ===> DONE"+companyVo.toString());
		        }else{
		     	   System.out.println("Insert failed ==>");
		     	  dbResult = "DB_FAILED";
		        }
		    }
/*           
		   EmployeeVO emp = jdbcTemplate.execute(sqlString, new PreparedStatementCallback<EmployeeVO>() {

			public EmployeeVO doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
			
				pstmt.setString(1, empVo.getEmployeeName());
				pstmt.setString(2, empVo.getEmail());
				pstmt.setString(3, empVo.getDepartment());
				pstmt.setString(4, empVo.getMobile());
				pstmt.setString(5, empVo.getCity());
				pstmt.setInt(6, empVo.getSalary());
				pstmt.setString(7, empVo.getActive());
				
				boolean result = pstmt.execute();
				System.out.println("Data Insert result ==> "+ result);			

				if(result == false){
	            	System.out.println("Data Updated Successfully");
	            }else if(result == true){
	            	System.out.println("ResultSet returned");
	            }else{
	            	System.out.println("Result is no hence data not updated");
	            }
				System.out.println("||||||"+ empVo.toString());
				return empVo;
			}
	      });

*/		   

		   return dbResult ;
	}

	
	
	
	public List<CompanyVO> getCompanyByUser(int userId) {
		  List<CompanyVO> companyList =  new ArrayList<CompanyVO>();
		  String sqlQuery = "SELECT companyId , companyName , businessCategory , yearOfCreation , founder , "
		  		+ "websiteAddress , city , contactEmail , noOfEmployees , contactNumber , fkCompanyUser "
		  		+ "FROM company_master WHERE fkCompanyUser = ? order by companyId DESC ";

		    companyList = jdbcTemplate.query(sqlQuery, new Object[]{userId} , new RowMapper<CompanyVO>() {

				public CompanyVO mapRow(ResultSet rs, int idx) throws SQLException {
					CompanyVO compVo = new CompanyVO();

					compVo.setCompanyId(rs.getInt("companyId"));
					compVo.setCompanyName(rs.getString("companyName"));
					compVo.setBusinessCategory(rs.getString("businessCategory"));
					compVo.setYearOfCreation(rs.getString("yearOfCreation"));
					compVo.setFounder(rs.getString("founder"));
					compVo.setWebsiteAddress(rs.getString("websiteAddress"));
					compVo.setCity(rs.getString("city"));
					compVo.setContactEmail(rs.getString("contactEmail"));
					compVo.setNoOfEmployees(rs.getInt("noOfEmployees"));
					compVo.setContactNumber(rs.getString("contactNumber"));
					compVo.setFkCompanyUseId(rs.getInt("fkCompanyUser"));
					return compVo;
				}
			});
			return companyList;
	}
	
	
	
	
	public List<CompanyVO> getAllCompany() {
		// TODO Auto-generated method stub
		return null;
	}
				
			
}

