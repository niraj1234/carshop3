package org.niraj.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CompanyVO {

	private int    companyId ; 
	
	@Size(min=5 , max=20 , message="Min 5 Max 20 Character Allowed")
	private String companyName;

	@NotEmpty(message="Category Must be filled")
	private String businessCategory;

	@NotEmpty(message="YoC Must be filled")
	private String yearOfCreation;
	
	@NotEmpty(message="Founder must present")
    private String founder;
	
	@NotNull
	@NotEmpty(message="Website Address Required")
    private String websiteAddress;
	
	@NotEmpty(message="City of Company Required")
    private String city;
	
	@NotEmpty(message="Email Required")
	@Email(message="Valid Email Required")
    private String contactEmail;
	
	@Min(value=1L , message="Please enter Employee Strength")
    private int    noOfEmployees;
	
	@Size(min=10 , max=10 , message="Company Contact Number Required")
	private String contactNumber;
		
	private int fkCompanyUseId;
	

/*	
	private String facebookLink;
	private String twitterLink;
	private String linkedkLink;
	private String country;
	private String state;
	private String androidApp;
	private String iosApp;

*/	

	
	
	
	public int getFkCompanyUseId() {
		return fkCompanyUseId;
	}
	public void setFkCompanyUseId(int fkCompanyUseId) {
		this.fkCompanyUseId = fkCompanyUseId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public String getYearOfCreation() {
		return yearOfCreation;
	}
	public void setYearOfCreation(String yearOfCreation) {
		this.yearOfCreation = yearOfCreation;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public String getWebsiteAddress() {
		return websiteAddress;
	}
	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	@Override
	public String toString() {
		return "CompanyVO [companyId=" + companyId + ", companyName=" + companyName + ", businessCategory="
				+ businessCategory + ", yearOfCreation=" + yearOfCreation + ", city=" + city + ", noOfEmployees="
				+ noOfEmployees + "]";
	}


	
}
