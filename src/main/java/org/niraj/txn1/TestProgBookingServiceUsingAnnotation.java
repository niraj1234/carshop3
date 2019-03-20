package org.niraj.txn1;

import org.springframework.context.ApplicationContext;

public class TestProgBookingServiceUsingAnnotation {

	public static void main(String[] args) {

		
		ApplicationContext context = Utils.getContext();
		
		
		BookingService bookingServiceAnno = (BookingService) context
				.getBean("ticketBookingServiceThroughAnnotation");		
		
		System.out.println("Booking the Tickets using Annotation ");
		bookingServiceAnno.bookTicket(1, 2, 2);
		System.out.println("Program Completed  Tickets using Annotation ");
		
		
		


/*		Not working for TicketUtils2
		TicketBookingServiceThroughAnnotation bookingServiceAnno2 = (TicketBookingServiceThroughAnnotation) context
				.getBean("ticketBookingServiceThroughAnnotation");		
		
		System.out.println("Booking the Tickets using Annotation 2");
		bookingServiceAnno2.bookTicket2(1, 2, 2);
		System.out.println("Program Completed  Tickets using Annotation 2");
		

*/		

	}

}
