package org.niraj.txn1;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;

public class TestProgramUsingAOP {

	public static void main(String[] args) {
		ApplicationContext context = Utils.getContext();

		TicketBookingServiceThroughAop service =
(TicketBookingServiceThroughAop)context.getBean("ticketBookingServiceThroughAop");
		
		
/*		DataSource dataSource = (DataSource) context.getBean("mySqlDataSource");
		service.setDataSource(dataSource);
*/		
	
	System.out.println("Booking Ticket usimg AOP ==>");
		service.bookTicket(1, 2, 1);
    System.out.println("Ticket booking program completed using AOP");	
	}

}
