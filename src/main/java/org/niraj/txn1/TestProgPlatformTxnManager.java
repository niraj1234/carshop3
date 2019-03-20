package org.niraj.txn1;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

public class TestProgPlatformTxnManager {

	public static void main(String[] args) {

		
		ApplicationContext context = Utils.getContext();
		
		TicketBookingServiceUsingPlatformTxnManager service = new TicketBookingServiceUsingPlatformTxnManager();
		
		DataSource dataSource = (DataSource) context.getBean("mySqlDataSource");
		service.setDataSource(dataSource);
		
		PlatformTransactionManager txnManager  = (PlatformTransactionManager) context.getBean("transactionManager");
		service.setTransactionManager(txnManager);

		System.out.println("Going to book Ticket ==");

		service.bookTicket(1, 1, 3);
		
		System.out.println("Program Completed ==");
		
		
		
	}

}
