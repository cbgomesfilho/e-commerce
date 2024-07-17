package br.com.ecommerce.controller.product.response;

import br.com.ecommerce.controller.category.response.CategoryResponse;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        Integer id,
        String name,
        String description,
        Integer availableQtd,
        BigDecimal price,
        CategoryResponse category
){}
