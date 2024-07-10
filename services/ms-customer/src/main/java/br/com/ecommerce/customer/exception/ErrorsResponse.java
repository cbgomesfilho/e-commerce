package br.com.ecommerce.customer.exception;


import java.util.Map;


public record ErrorsResponse(Map<String,String> errors){}
