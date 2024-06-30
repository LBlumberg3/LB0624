package com.example.kewltewls.exception;

/**
 * Custom child of RuntimeException, to be thrown when some issue is encountered in client auth, and caught by the dedicated @ControllerAdvice-decorated method 
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message){
        super(message);
    }
}
