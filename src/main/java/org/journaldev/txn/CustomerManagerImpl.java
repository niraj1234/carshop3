package org.journaldev.txn;

import org.springframework.transaction.annotation.Transactional;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Transactional
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}
	
}
