package br.com.ecommerce.customer.service;

import br.com.ecommerce.customer.controller.response.CustomersResponse;
import br.com.ecommerce.customer.exception.CustomerNotFoundException;
import br.com.ecommerce.customer.model.Customer;
import br.com.ecommerce.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    public String create(Customer domain) {
        var customerEntity = this.customerRepository.save(domain);
        return "Customer created with successfully : " + customerEntity.getId();
    }

    public void update(Customer domain) {
        var document = customerRepository.findById(domain.getId())
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Cannot update customer:: " +
                        "No customer found with provided ID:: %s", domain.getId())));

        createMergeCustomer(document, domain);
        this.customerRepository.save(document);
    }

    private void createMergeCustomer(Customer document, Customer domain) {

        if(StringUtils.isNotBlank(domain.getFirst_name())){
            document.setFirst_name(domain.getFirst_name());
        }
        if(StringUtils.isNotBlank(domain.getLast_name())){
            document.setLast_name(domain.getLast_name());
        }
        if(StringUtils.isNotBlank(domain.getEmail())){
            document.setEmail(domain.getEmail());
        }

        if(domain.getAddress() != null) {
            document.setAddress(domain.getAddress());
        }
    }

    public List<Customer> list() {
       return this.customerRepository.findAll();
    }

    public Boolean existsCustomer(String customerId) {
        return this.customerRepository.findById(customerId).isPresent();
    }

    public CustomersResponse findById(String customerId) {
        var response = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Cannot update customer:: " +
                        "No customer found with provided ID:: %s", customerId)));

        return CustomersResponse.builder()
                .id(response.getId())
                .email(response.getEmail())
                .first_name(response.getFirst_name())
                .last_name(response.getLast_name())
                .build();
    }
}
