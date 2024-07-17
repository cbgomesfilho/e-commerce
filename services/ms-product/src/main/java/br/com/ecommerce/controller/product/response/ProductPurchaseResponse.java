package br.com.ecommerce.controller.product.response;

import lombok.Builder;

import java.math.BigDecimal;


@Builder
public record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        Integer quantity

) {
}
