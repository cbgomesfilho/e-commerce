package br.com.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductNotFoundException extends RuntimeException {
    private final String msg;

}
