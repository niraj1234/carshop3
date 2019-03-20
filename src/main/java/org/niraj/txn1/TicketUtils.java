package org.niraj.txn1;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TicketUtils {



	public static UserAccount getUserAccountByUserId(JdbcTemplate template, int userId){

		String sqlQuery = "SELECT userPkId, userName, mobile, email, "
				+ "accountPkId, amount, accountStatus, fkUserId "
				+ "FROM movie_account ma , movie_user mu "
				+ "WHERE ma.fkUserId = mu.userPkId AND mu.userPkId = ? ";

		UserAccount userAcctReturn = null; 
		int accountId = -1;

        List<UserAccount> userAccountList = new ArrayList<UserAccount>();
        
        userAccountList = template.query(sqlQuery, new Object[]{userId} , new RowMapper<UserAccount>(){

			public UserAccount mapRow(ResultSet rs, int idx) throws SQLException {
		        UserAccount userAcct = new UserAccount();

		        userAcct.setUserPkId( rs.getInt("userPkId") );
		        userAcct.setUserName(rs.getString("userName"));
		        userAcct.setMobile(rs.getString("mobile"));
		        userAcct.setEmail(rs.getString("email"));
                
		        userAcct.setAccountPkId(rs.getInt("accountPkId") );
		        userAcct.setAmount(rs.getInt("amount") );
		        userAcct.setAccountStatus(rs.getString("accountStatus"));
		        userAcct.setFkUserId(rs.getInt("fkUserId") );
				
				return userAcct;
			}
        	
        } );
	    
        if(userAccountList.size() > 0){
        	userAcctReturn = new UserAccount();
        	userAcctReturn = userAccountList.get(0);
        }
    	return userAcctReturn;
	}
	

	public static 	MovieTicket  getMovieTicketById(JdbcTemplate template , int movieId){
        
		String sqlQuery = "SELECT moviePkId, movieName, noOfTicket, price FROM movie_ticket WHERE moviePkId = ?" ;
		
		MovieTicket movieTicketReturn = null;
		
		List<MovieTicket> movieTicletList = new ArrayList<MovieTicket>();
		
		movieTicletList = template.query(sqlQuery, new Object[] { movieId }, new RowMapper<MovieTicket>() {

			public MovieTicket mapRow(ResultSet rs, int idx) throws SQLException {
				MovieTicket movieTicket = new MovieTicket();
				movieTicket.setMovieId(rs.getInt("moviePkId"));
				movieTicket.setMovieName(rs.getString("movieName"));
				movieTicket.setPrice(rs.getInt("price"));
				movieTicket.setTotalTicketsCount(rs.getInt("noOfTicket"));

				return movieTicket;
			}

		});		
		
		
		if(movieTicletList.size()>0){
			movieTicketReturn = new MovieTicket();
			movieTicketReturn = movieTicletList.get(0);
		}
		
		return movieTicketReturn;
	}
	
	public static void deductMoneyFromAccount(JdbcTemplate template, int accountId, float amount){
		String sql = "UPDATE movie_account SET amount = (amount - " + amount + ") WHERE fkUserId = " + accountId + " ";
		template.execute(sql);
	}
	
	
	public static void reduceTicketCount(JdbcTemplate template, int ticketId, int noOfTickets){
//	    String sql2 = "UPDATE movie_ticket SET noOfTicket1 = (noOfTicket - " + noOfTickets + ") WHERE moviePkId = " + ticketId + " ";
	
		//  here noOfTicket column is change dto noOfTicket1 hence forcing the application to fail the query 
	    String sql2 = "UPDATE movie_ticket SET noOfTicket = (noOfTicket - " + noOfTickets + ") WHERE moviePkId = " + ticketId + " ";
		template.execute(sql2);
	}
	
	public static int balanceMoney(JdbcTemplate template, int accountId){
		String sql = "SELECT amount FROM movie_account WHERE fkUserId = " + accountId + " ";
		return template.queryForInt(sql);
	}	
	
}

