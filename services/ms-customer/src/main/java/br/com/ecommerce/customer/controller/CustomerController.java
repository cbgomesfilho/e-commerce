package br.com.ecommerce.customer.controller;

import br.com.ecommerce.customer.controller.request.CustomerRequest;
import br.com.ecommerce.customer.controller.response.CustomerResponse;
import br.com.ecommerce.customer.controller.response.CustomersResponse;
import br.com.ecommerce.customer.mapper.CustomerMapper;
import br.com.ecommerce.customer.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;
    private final CustomerMapper mapper;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
       var response = customerService.create(mapper.toCustomer(request));

       return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse.builder()
               .created(response.toUpperCase())
               .build());
    }

    @GetMapping
    public ResponseEntity<List<CustomersResponse>> list() {
        var response = customerService.list()
                .stream().map(mapper::toCustomerResponse).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> exists(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(this.customerService.existsCustomer(customerId));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomersResponse> customer(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(this.customerService.findById(customerId));
    }
}
