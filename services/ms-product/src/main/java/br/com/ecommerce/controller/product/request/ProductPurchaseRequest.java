package br.com.ecommerce.controller.product.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record ProductPurchaseRequest(

        @NotNull(message = "Product id is required")
        Integer productId,
        @NotNull(message = "Quantity id is required")
        Integer quantity
) {
}
