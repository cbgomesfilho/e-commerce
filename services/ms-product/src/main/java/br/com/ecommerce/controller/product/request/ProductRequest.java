package br.com.ecommerce.controller.product.request;


import br.com.ecommerce.controller.category.request.CategoryRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductRequest (

        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @Positive(message = "Product available quantity should be positive")
        Integer availableQtd,
        @Positive(message = "Product price should be positive")
        BigDecimal price,
        @NotNull(message = "Category description is required")
        CategoryRequest category
) {
}
