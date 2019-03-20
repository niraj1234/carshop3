package org.niraj.txn1;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TicketBookingServiceThroughAop extends JdbcDaoSupport{
	public void bookTicket(int userId, int movieId, int noOfTickets){

		UserAccount userAccount= TicketUtils.getUserAccountByUserId(getJdbcTemplate(), userId);
		int accountId = userAccount.getAccountPkId();

		MovieTicket movieTicket  = TicketUtils.getMovieTicketById(getJdbcTemplate(), movieId);
		
		int ticketCost = movieTicket.getPrice();
		int totalCost = (noOfTickets * ticketCost);

		TicketUtils.deductMoneyFromAccount(getJdbcTemplate(), accountId, totalCost);
		TicketUtils.reduceTicketCount(getJdbcTemplate(), movieId, noOfTickets);
	}	
}
