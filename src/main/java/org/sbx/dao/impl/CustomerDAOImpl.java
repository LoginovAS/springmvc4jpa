package org.sbx.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.dao.CustomerDAO;
import org.sbx.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by loginov_a_s on 20.06.2017.
 */

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    private static Logger logger = LogManager.getLogger();

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public Customer addCustomer(Customer customer) {

        entityManager.persist(customer);

        return customer;

    }

    @Transactional
    public Customer updateCustomer(Customer customer) {

        entityManager.merge(customer);

        return customer;

    }

    @Transactional
    public void deleteCustomer(long customerId) {
        entityManager.remove(getCustomer(customerId));
    }

    @Transactional(readOnly = true)
    public Customer getCustomer(long customerId) {

        String sql = "select customer from Customer customer where customer.customerId="+customerId;

        try{
            return (Customer) entityManager.createQuery(sql).getSingleResult();
        }catch(Exception ex){
            logger.error(ex);
        }

        return null;

    }

    @Transactional(readOnly = true)
    public List<Customer> getCustomers() {

        return entityManager.createQuery("select customer from Customer customer").getResultList();

    }
}
