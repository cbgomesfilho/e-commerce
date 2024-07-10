package br.com.ecommerce.customer.mapper;

import br.com.ecommerce.customer.controller.request.CustomerRequest;
import br.com.ecommerce.customer.controller.response.CustomersResponse;
import br.com.ecommerce.customer.model.Address;
import br.com.ecommerce.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .email(request.email())
                .first_name(request.first_name())
                .last_name(request.last_name())
                .address(Address.builder()
                        .house_number(request.address().house_number())
                        .street(request.address().street())
                        .zip_code(request.address().zip_code())
                        .build())
                .build();
    }

    public CustomersResponse toCustomerResponse(Customer customer) {
        return CustomersResponse.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .first_name(customer.getFirst_name())
                .last_name(customer.getLast_name())
                .build();
    }
}
