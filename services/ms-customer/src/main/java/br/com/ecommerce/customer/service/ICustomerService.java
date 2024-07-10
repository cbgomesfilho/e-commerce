package br.com.ecommerce.customer.service;


import br.com.ecommerce.customer.controller.response.CustomersResponse;
import br.com.ecommerce.customer.model.Customer;

import java.util.List;

public interface ICustomerService {

    String create(Customer domain);

    void update(Customer domain);

    List<Customer> list();

    Boolean existsCustomer(String customerId);

    CustomersResponse findById(String customerId);

}
