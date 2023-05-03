package sg.edu.nus.iss.day21.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sg.edu.nus.iss.day21.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {
    

    // RowMapper is a callback interface that is called for each row and maps the row of relations with the instances to the model(user-defined) class
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();

        customer.setId(rs.getInt("id"));
        customer.setCompany(rs.getString("company"));
        customer.setLastName(rs.getString("last_name"));
        customer.setFirstName(rs.getString("first_name"));
    
        return customer;
    }
   
}
