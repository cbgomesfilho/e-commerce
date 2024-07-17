package br.com.ecommerce.api;

import br.com.ecommerce.controller.product.request.ProductRequest;
import br.com.ecommerce.controller.product.request.ProductPurchaseRequest;
import br.com.ecommerce.controller.product.response.ProductPurchaseResponse;
import br.com.ecommerce.controller.product.response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
public interface ProductResource {

    @PostMapping
    ResponseEntity<Integer> create(@RequestBody @Valid ProductRequest request);

    @PostMapping("/purchase")
    ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(@RequestBody List<ProductPurchaseRequest> request );

    @GetMapping("/{purchase-id}")
    ResponseEntity<ProductResponse> product(@PathVariable("purchase-id") Integer purchaseId);

    @GetMapping
    ResponseEntity<List<ProductResponse>> products();
}
