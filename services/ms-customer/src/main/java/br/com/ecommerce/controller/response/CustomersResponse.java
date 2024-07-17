package br.com.ecommerce.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomersResponse {

    private String id;

    private String first_name;

    private String last_name;

    private String email;
}
