package br.com.ecommerce.service.vo;

import lombok.Builder;

@Builder
public record ProductPurchaseVO(Integer productId, Integer quantity) {}
