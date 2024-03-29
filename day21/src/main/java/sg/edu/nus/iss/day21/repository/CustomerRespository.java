package sg.edu.nus.iss.day21.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day21.model.Customer;
import sg.edu.nus.iss.day21.model.Order;

import static sg.edu.nus.iss.day21.repository.DBQueries.*;

@Repository
public class CustomerRespository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // fetch all customers
    public List<Customer> getAllCustomers(Integer offset, Integer limit){
        List<Customer> csts = new ArrayList<>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_ALL_CUSTOMERS, offset, limit);

        while (rs.next()){
            csts.add(Customer.create(rs));

        }

        return csts;

    }

    public Customer findCustomerById(Integer id){
        List<Customer> customers = jdbcTemplate.query(SELECT_CUSTOMER_BY_ID, new CustomerRowMapper(), new Object[] {id});

        return customers.get(0);
    }

     public List<Order>  getCustomerOrders(Integer id) {
        List<Order> orders = new ArrayList<Order>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_ORDERS_FOR_CUSTOMERS, new Object[] {id});

        while (rs.next()) {
            orders.add(Order.create(rs));
        }

        return orders;
        
     }
}
