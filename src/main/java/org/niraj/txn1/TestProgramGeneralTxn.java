package org.niraj.txn1;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestProgramGeneralTxn {

	public static void main(String[] args) {

		
		JdbcTemplate template = Utils.jdbcTempalte();
		TicketBookingService service = new TicketBookingService();
		service.setTemplate(template);

		System.out.println("Going to book Ticket");
		service.bookTicket(1, 4, 2);
		System.out.println("Program Completed ==>");
		
	}

}
