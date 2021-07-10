package tech.suracho.employeeportal.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException(String message) {
        super(message);
    }
}
