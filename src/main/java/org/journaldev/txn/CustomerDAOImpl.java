package org.journaldev.txn;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDAOImpl implements CustomerDAO {

		private DataSource dataSource;
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		
		public void create(Customer customer) {
			String queryCustomer = "insert into Customer (id, name) values (?,?)";
			String queryAddress  = "insert into Address (id, address,country) values (?,?,?)";

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(queryCustomer, new Object[] { customer.getId(),customer.getName() });
			System.out.println("Inserted into Customer Table Successfully");
			
			int custId = jdbcTemplate.queryForInt("select max(id) from customer");
			System.out.println("Customer Id ==> " + custId);
			jdbcTemplate.update(queryAddress, new Object[] { customer.getId(),customer.getAddress().getAddress(),customer.getAddress().getCountry() });
			System.out.println("Inserted into Address Table Successfully");
		}
		
}


