package br.com.ecommerce.controller;

import br.com.ecommerce.api.ProductResource;
import br.com.ecommerce.controller.product.request.ProductPurchaseRequest;
import br.com.ecommerce.controller.product.request.ProductRequest;
import br.com.ecommerce.controller.product.response.ProductPurchaseResponse;
import br.com.ecommerce.controller.product.response.ProductResponse;
import br.com.ecommerce.mapper.MapperObjects;
import br.com.ecommerce.service.CategoryService;
import br.com.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController implements ProductResource {

    private final ProductService service;

    private final CategoryService categoryService;

    private final MapperObjects mapper;

    @Override
    public ResponseEntity<Integer> create(ProductRequest request) {
        var response = this.service.createProduct(mapper.toProduct(request));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(List<ProductPurchaseRequest> request) {
        var products = mapper.toListProductPurchaseVO(request);
        var response = service.listProductPurchase(products);
        return ResponseEntity.ok(mapper.toListProductPurchaseResponse(response));
    }

    @Override
    public ResponseEntity<ProductResponse> product(Integer purchaseId) {
        return ResponseEntity.ok(mapper.toProductResponse(this.service.findProductById(purchaseId)));
    }

    @Override
    public ResponseEntity<List<ProductResponse>> products() {
        return ResponseEntity.ok(mapper.toListProductResponse(this.service.allProducts()));
    }


}
