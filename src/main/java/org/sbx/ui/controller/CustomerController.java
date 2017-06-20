package org.sbx.ui.controller;

import org.sbx.entity.Customer;
import org.sbx.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by loginov_a_s on 20.06.2017.
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    @Qualifier("customerService")
    private CustomerService customerService;

    @GetMapping("/")
    public String getHome() {
        return "redirect:customers.action";
    }

    @GetMapping("/customers")
    public ModelAndView getCustomers() {

        ModelAndView model = new ModelAndView("customers");
        List<Customer> list = customerService.getAllCustomers();
        model.addObject("customers", list);

        return model;

    }

    @GetMapping("/editCustomerView/{customerId}")
    public ModelAndView getEditCustomerForm(@PathVariable("customerId") String customerId) {

        ModelAndView model = new ModelAndView("editCustomer");
        Customer customer = customerService.getCustomer(Long.parseLong(customerId));
        model.addObject("customer", customer);

        return model;

    }

    

}
