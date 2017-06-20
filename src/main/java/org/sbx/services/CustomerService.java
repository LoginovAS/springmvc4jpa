package org.sbx.services;

import org.sbx.entity.Customer;

import java.util.List;

/**
 * Created by loginov_a_s on 20.06.2017.
 */
public interface CustomerService {

    Customer addCustomer(String customerName, String country);

    Customer updateCustomer(long cutomerId, String customerName, String country);

    Customer getCustomer(long customerId);

    public List<Customer> getAllCustomers();

}
