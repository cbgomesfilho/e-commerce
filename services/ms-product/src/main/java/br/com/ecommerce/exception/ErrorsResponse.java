package br.com.ecommerce.exception;


import java.util.Map;


public record ErrorsResponse(Map<String,String> errors){}
