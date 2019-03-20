package org.niraj.txn1;

import java.sql.Connection;

import org.springframework.jdbc.core.JdbcTemplate;

public class TicketBookingService {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template){
		this.template = template;
	}
	
	
	public void bookTicket(int userId, int movieId, int noOfTickets){

		Connection connection = null;
		try{
			connection = template.getDataSource().getConnection();
			connection.setAutoCommit(false);

			UserAccount userAccount= TicketUtils.getUserAccountByUserId(template, userId);
			int accountId = userAccount.getAccountPkId();

			MovieTicket movieTicket  = TicketUtils.getMovieTicketById(template, movieId);
			
			int ticketCost = movieTicket.getPrice();
			int totalCost = (noOfTickets * ticketCost);

			TicketUtils.deductMoneyFromAccount(template, accountId, totalCost);
			TicketUtils.reduceTicketCount(template, movieId, noOfTickets);

			System.out.println("No Exception  Hence COMMIT");
			connection.commit();

		}catch (Exception exception){
			exception.printStackTrace();
			if (connection != null){
				try{
					System.out.println("Exception generated Hence ROLLBACK");
					connection.rollback();
				}catch (Exception e1){
					e1.printStackTrace();
				}
			}
		}
	}
	
}
