package com.milan.demo.zip.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomIOException extends Exception {

	public CustomIOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomIOException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomIOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomIOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
