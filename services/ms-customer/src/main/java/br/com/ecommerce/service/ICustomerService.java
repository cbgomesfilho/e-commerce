package br.com.ecommerce.service;


import br.com.ecommerce.controller.response.CustomersResponse;
import br.com.ecommerce.model.Customer;

import java.util.List;

public interface ICustomerService {

    String create(Customer domain);

    void update(Customer domain);

    List<Customer> list();

    Boolean existsCustomer(String customerId);

    CustomersResponse findById(String customerId);

}
