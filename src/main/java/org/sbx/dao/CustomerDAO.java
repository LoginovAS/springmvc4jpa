package org.sbx.dao;

import org.sbx.entity.Customer;

import java.util.List;

/**
 * Created by loginov_a_s on 20.06.2017.
 */
public interface CustomerDAO {

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(long customerId);

    Customer getCustomer(long customerId);

    List<Customer> getCustomers();
}
