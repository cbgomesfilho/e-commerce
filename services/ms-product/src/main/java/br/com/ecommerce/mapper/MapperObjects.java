package br.com.ecommerce.mapper;

import br.com.ecommerce.controller.category.response.CategoryResponse;
import br.com.ecommerce.controller.product.request.ProductPurchaseRequest;
import br.com.ecommerce.controller.product.request.ProductRequest;
import br.com.ecommerce.controller.product.response.ProductPurchaseResponse;
import br.com.ecommerce.controller.product.response.ProductResponse;
import br.com.ecommerce.model.Category;
import br.com.ecommerce.model.Product;
import br.com.ecommerce.service.vo.ProductPurchaseVO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class MapperObjects {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQtd())
                .price(request.price())
                .category(Category.builder()
                        .id(request.category().id())
                        .build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        var category = CategoryResponse.builder()
                .id(product.getCategory().getId())
                .name(product.getCategory().getName())
                .description(product.getCategory().getDescription())
                .build();
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQtd(product.getAvailableQuantity())
                .price(product.getPrice())
                .category(category)
                .build();
    }

    public List<ProductPurchaseResponse> toListProductPurchaseResponse(List<ProductPurchaseVO> purchaseProduct) {
        return purchaseProduct.stream()
                .map(p ->
                        ProductPurchaseResponse.builder()
                                .productId(p.productId())
                                .quantity(p.quantity())
                                .build()
                ).collect(Collectors.toList());
    }

    public List<ProductPurchaseVO> toListProductPurchaseVO(List<ProductPurchaseRequest> productPurchaseRequests) {
        return productPurchaseRequests.stream()
                .map(p ->
                        ProductPurchaseVO.builder()
                                .productId(p.productId())
                                .quantity(p.quantity())
                                .build()
                ).collect(Collectors.toList());
    }

    public List<ProductResponse> toListProductResponse(List<Product> products) {
        return products.stream()
                .map(p ->
                        ProductResponse.builder()
                                .name(p.getName())
                                .description(p.getDescription())
                                .price(p.getPrice())
                                .availableQtd(p.getAvailableQuantity())
                                .category(CategoryResponse.builder()
                                        .id(p.getCategory().getId())
                                        .description(p.getCategory().getDescription())
                                        .name(p.getCategory().getName())
                                        .build())
                                .build()
                ).collect(Collectors.toList());
    }
}
