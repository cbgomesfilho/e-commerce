package br.com.ecommerce.controller.request;

import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
public record AddressRequest(String street,String house_number, String zip_code) {}
