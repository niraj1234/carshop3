package org.niraj.txn1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SimpleTxnTest {

	public static void main(String args[]){
		
		
		Connection conn = null;
		String url ="jdbc:mysql://localhost:3306/carshop3";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			conn.setAutoCommit(false);
			
			
			String sql1 = "UPDATE movie_account SET amount = (amount - 300) WHERE fkUserId = 1";
			String sql2 = "UPDATE movie_ticket SET noOfTicket1 = (noOfTicket - 2) WHERE moviePkId = 4";
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			int i1 = pstmt1.executeUpdate();

			System.out.println("Result 1 ==> " + i1 );

			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			int i2 = pstmt2.executeUpdate();
			
			System.out.println("Result 2 ==> " +i2);

			System.out.println("No Exception hence COMMIT ===>");

			conn.commit();
		}catch(Exception ex){
			try {
				System.out.println("Roll back the connection ====>");
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
