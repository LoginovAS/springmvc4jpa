package org.sbx.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.dao.CustomerDAO;
import org.sbx.entity.Customer;
import org.sbx.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by loginov_a_s on 20.06.2017.
 */

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    @Qualifier("customerDAO")
    private CustomerDAO customerDAO;

    @Transactional
    public Customer addCustomer(String customerName, String country) {

        logger.info("Customer Service create invoked: " + customerName);

        Customer customer = new Customer();

        customer.setCustomerName(customerName);
        customer.setCountry(country);
        customer.setCreatedDate(new Date());
        customer.setUpdateDate(new Date());

        return customerDAO.addCustomer(customer);

    }

    @Transactional
    public Customer updateCustomer(long customerId, String customerName, String country) {

        logger.info("Customer Service Update invoked: " + customerName);

        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setCountry(country);
        customer.setCustomerName(customerName);
        customer.setUpdateDate(new Date());

        return customerDAO.updateCustomer(customer);

    }

    @Transactional
    public Customer getCustomer(long customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDAO.getCustomers();
    }
}
