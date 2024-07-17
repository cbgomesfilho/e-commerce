package br.com.ecommerce.service.impl;

import br.com.ecommerce.controller.product.response.ProductResponse;
import br.com.ecommerce.exception.ProductNotFoundException;
import br.com.ecommerce.exception.ProductPurchaseException;
import br.com.ecommerce.model.Product;
import br.com.ecommerce.repository.ProductRepository;
import br.com.ecommerce.service.ProductService;
import br.com.ecommerce.service.vo.ProductPurchaseVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.*;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Integer createProduct(Product product) {
        return this.repository.save(product).getId();
    }

    @Override
    public List<Product> purchaseProduct(List<Product> productList) {
        return repository.saveAll(productList);
    }

    @Override
    public Product findProductById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(format("Product not found to id %d", id)));
    }

    @Override
    public List<Product> allProducts() {
        return repository.findAll();
    }

    @Override
    public List<ProductPurchaseVO> listProductPurchase(List<ProductPurchaseVO> productPurchase) {
        var productIds = productPurchase
                .stream()
                .map(ProductPurchaseVO::productId)
                .toList();

        var storeProducts =  repository.findAllByIdInOrderById(productIds);

        if (productIds.size() != storeProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exists");
        }

        var storesRequest = productPurchase.stream()
                .sorted(Comparator.comparing(ProductPurchaseVO::productId))
                .toList();

        var purchaseProducts = new ArrayList<ProductPurchaseVO>();

        for (int i = 0; i < purchaseProducts.size(); i++) {
            var product = storeProducts.get(i);
            var productRequest = storesRequest.get(i);

            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product whit ID::"
                        + productRequest.productId());
            }

            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);
        }

        return purchaseProducts;

    }
}
