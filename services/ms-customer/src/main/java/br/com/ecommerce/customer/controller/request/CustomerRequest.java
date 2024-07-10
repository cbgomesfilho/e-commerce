package br.com.ecommerce.customer.controller.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (

    @NotNull(message = "first_name - Is not by blank" )
    String first_name,

    @NotNull(message = "last_name - Is not by blank")
    String last_name,

    @NotNull(message = "E-mail is not valid address")
    @Email(message = "E-mail is not valid address")
    String email,

    AddressRequest address
){}
