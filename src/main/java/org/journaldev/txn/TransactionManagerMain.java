package org.journaldev.txn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionManagerMain {

	public static void main(String[] args) {
		
		String configFile = "org/journaldev/txn/appBeansTxnJournalDev.xml";

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				configFile);

		CustomerManager customerManager = ctx.getBean("customerManager",CustomerManagerImpl.class);
		Customer cust = createDummyCustomer();
		customerManager.createCustomer(cust);

		ctx.close();
		System.out.println("Program Completed JournalDev==>");
	}

	private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(6);
		customer.setName("Sanjeev");
		Address address = new Address();
		address.setId(5);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
//		address.setAddress("Sector 40 Gurgaon This needs to be failed ");
		address.setAddress("Ramnagar Extension More than 20 chars");
		customer.setAddress(address);
		return customer;
	}
}
