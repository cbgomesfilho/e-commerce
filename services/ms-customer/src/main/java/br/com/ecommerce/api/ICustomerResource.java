package br.com.ecommerce.api;

import br.com.ecommerce.controller.request.CustomerRequest;
import br.com.ecommerce.controller.response.CustomerResponse;
import br.com.ecommerce.controller.response.CustomersResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customers")
public interface ICustomerResource {

     @PostMapping
     ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request);
     @GetMapping
     ResponseEntity<List<CustomersResponse>> list();

     @GetMapping("/exists/{customer-id}")
     ResponseEntity<Boolean> exists(@PathVariable("customer-id") String customerId);


    @GetMapping("/{customer-id}")
    ResponseEntity<CustomersResponse> customer(@PathVariable("customer-id") String customerId);


}
