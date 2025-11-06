package com.raanjhana.repository;

import com.raanjhana.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private final RowMapper<Customer> customerMapper = (rs, rowNum) -> {
        Customer c = new Customer();
        c.setPhoneNumber(rs.getString("phone_number"));
        c.setName(rs.getString("name"));
        return c;
    };

    public int save(Customer c) {
        String sql = "INSERT INTO customers (phone_number, name) VALUES (?, ?)";
        return jdbcTemplate.update(sql, c.getPhoneNumber(), c.getName());
    }

    public int update(Customer c) {
        String sql = "UPDATE customers SET name=? WHERE phone_number=?";
        return jdbcTemplate.update(sql, c.getName(), c.getPhoneNumber());
    }

    public List<Customer> findAll() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, customerMapper);
    }

    public List<Customer> findByPhone(String phone) {
        String sql = "SELECT * FROM customers WHERE phone_number = ?";
        return jdbcTemplate.query(sql, customerMapper, phone);
    }

    public int delete(String phone) {
        String sql = "DELETE FROM customers WHERE phone_number=?";
        return jdbcTemplate.update(sql, phone);
    }

    public boolean existsByPhone(String phone) {
        String sql = "SELECT COUNT(*) FROM customers WHERE phone_number = ?";
        Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class, phone);
        return cnt != null && cnt > 0;
    }
}
