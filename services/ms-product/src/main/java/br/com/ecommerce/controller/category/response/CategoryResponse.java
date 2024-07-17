package br.com.ecommerce.controller.category.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Integer id, String name, String description) {
}
