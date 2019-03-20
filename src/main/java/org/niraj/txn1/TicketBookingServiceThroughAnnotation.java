package org.niraj.txn1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class TicketBookingServiceThroughAnnotation extends JdbcDaoSupport implements BookingService{

// This class also has on dataSource that needs to be injected as this class is extending the JdbcDaoSupport.
// Hence in bean configuration file , dataSource must be injected using setter method	
	
	
	

	@Transactional
	public void bookTicket(int userId, int movieId, int noOfTickets){

	  try{
			UserAccount userAccount= TicketUtils.getUserAccountByUserId(getJdbcTemplate(), userId);
			int accountId = userAccount.getAccountPkId();

			MovieTicket movieTicket  = TicketUtils.getMovieTicketById(getJdbcTemplate(), movieId);
			
			int ticketCost = movieTicket.getPrice();
			int totalCost = (noOfTickets * ticketCost);

			TicketUtils.deductMoneyFromAccount(getJdbcTemplate(), accountId, totalCost);
			TicketUtils.reduceTicketCount(getJdbcTemplate(), movieId, noOfTickets);
           
			System.out.println("Everything is fine");
	  }catch(Exception ex){
		  System.out.println("Exception in ");
		  ex.printStackTrace();

	  }

	}	



/*  This is also not working even JdbcTemplate is injected directly
	@Transactional
	public void bookTicket2(int userId, int movieId, int noOfTickets){

	  try{
			UserAccount userAccount= TicketUtils2.getUserAccountByUserId(userId);
			int accountId = userAccount.getAccountPkId();

			MovieTicket movieTicket  = TicketUtils2.getMovieTicketById( movieId);
			
			int ticketCost = movieTicket.getPrice();
			int totalCost = (noOfTickets * ticketCost);

			TicketUtils2.deductMoneyFromAccount( accountId, totalCost);
			TicketUtils2.reduceTicketCount( movieId, noOfTickets);
           
			System.out.println("Everything is fine bookTicket2 ");
	  }catch(Exception ex){
		  System.out.println("Exception in bookTicket2");
	  }

	}	

*/



	
/*	
	JdbcTemplate jdbcTemplate;
   
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public void bookTicket(int userId, int movieId, int noOfTickets){

	  try{
			UserAccount userAccount= TicketUtils.getUserAccountByUserId(jdbcTemplate, userId);
			int accountId = userAccount.getAccountPkId();

			MovieTicket movieTicket  = TicketUtils.getMovieTicketById(jdbcTemplate, movieId);
			
			int ticketCost = movieTicket.getPrice();
			int totalCost = (noOfTickets * ticketCost);

			TicketUtils.deductMoneyFromAccount(jdbcTemplate, accountId, totalCost);
			TicketUtils.reduceTicketCount(jdbcTemplate, movieId, noOfTickets);
           
			System.out.println("Everything is fine");
	  }catch(Exception ex){
		  System.out.println("Exception in ");
	  }

	}	

*/

	
}
