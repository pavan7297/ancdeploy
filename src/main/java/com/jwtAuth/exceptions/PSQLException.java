package com.jwtAuth.exceptions;

import java.sql.SQLException;

public class PSQLException extends SQLException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6585447492052791230L;

	// Default constructor
    public PSQLException() {
        super();
    }

    // Constructor with a custom error message
    public PSQLException(String message) {
        super(message);
    }

    // Constructor with a custom error message and cause
    public PSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with cause only
    public PSQLException(Throwable cause) {
        super(cause);
    }

    // Constructor with message, SQLState, and vendorCode
    public PSQLException(String message, String SQLState, int vendorCode) {
        super(message, SQLState, vendorCode);
    }

    // Constructor with message, SQLState
    public PSQLException(String message, String SQLState) {
        super(message, SQLState);
    }

    // Override toString() method to give a custom string representation
    @Override
    public String toString() {
        return "PSQLException: " + getMessage();
    }
	

}
