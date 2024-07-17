package br.com.ecommerce.controller;

import br.com.ecommerce.controller.request.CustomerRequest;
import br.com.ecommerce.api.ICustomerResource;
import br.com.ecommerce.controller.response.CustomerResponse;
import br.com.ecommerce.controller.response.CustomersResponse;
import br.com.ecommerce.mapper.CustomerMapper;
import br.com.ecommerce.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class CustomerController implements ICustomerResource {

    private final ICustomerService customerService;
    private final CustomerMapper mapper;

    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
       var response = customerService.create(mapper.toCustomer(request));

       return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse.builder()
               .created(response.toUpperCase())
               .build());
    }

    public ResponseEntity<List<CustomersResponse>> list() {
        var response = customerService.list()
                .stream().map(mapper::toCustomerResponse).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<Boolean> exists(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(this.customerService.existsCustomer(customerId));
    }

    public ResponseEntity<CustomersResponse> customer(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(this.customerService.findById(customerId));
    }
}
