package jmgomez.policyapi.exception;

public class CallNotPermittedException extends RuntimeException{

    public CallNotPermittedException(String message) {
        super(message);
    }
}
