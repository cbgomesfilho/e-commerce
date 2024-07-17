package br.com.ecommerce.controller.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (

    @NotBlank(message = "first_name - Is not by blank" )
    @NotNull(message = "first_name - Is not by null" )
    String first_name,

    @NotBlank(message = "last_name - Is not by blank")
    @NotNull(message = "last_name - Is not by null")
    String last_name,

    @NotBlank(message = "E-mail is not valid blank")
    @NotNull(message = "E-mail is not valid null")
    @Email(message = "E-mail is not valid address")
    String email,

    AddressRequest address
){}
