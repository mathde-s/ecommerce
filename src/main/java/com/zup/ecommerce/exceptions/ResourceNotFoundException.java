package com.zup.ecommerce.exceptions;

public class ResourceNotFoundException extends IllegalArgumentException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
