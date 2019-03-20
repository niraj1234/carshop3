package org.niraj.txn1;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TicketBookingServiceUsingPlatformTxnManager extends JdbcDaoSupport {

	private PlatformTransactionManager transactionManager;

	public void setTransactionManager(PlatformTransactionManager transactionManager){
		this.transactionManager = transactionManager;
	}
	
	

	public void bookTicket(int userId, int movieId, int noOfTickets){ 
	  TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
	  TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
	
	  
	  try{
			UserAccount userAccount= TicketUtils.getUserAccountByUserId(getJdbcTemplate(), userId);
			int accountId = userAccount.getAccountPkId();

			MovieTicket movieTicket  = TicketUtils.getMovieTicketById(getJdbcTemplate(), movieId);
			
			int ticketCost = movieTicket.getPrice();
			int totalCost = (noOfTickets * ticketCost);

			TicketUtils.deductMoneyFromAccount(getJdbcTemplate(), accountId, totalCost);
			TicketUtils.reduceTicketCount(getJdbcTemplate(), movieId, noOfTickets);
             
			System.out.println("Everything is fine in Platform Txn Manager Hence COMMIT");
			transactionManager.commit(status);
	  }catch(Exception ex){
		  System.out.println("Exception in PlatFormTransactionManager code hence ROLLBACK");
		  transactionManager.rollback(status);
	  }
	  
	  
	}
	
	
	
	
	
}
