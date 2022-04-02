package com.milan.demo.zip.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
public class UnsupportedAlgorithmException extends Exception {

	public UnsupportedAlgorithmException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnsupportedAlgorithmException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnsupportedAlgorithmException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnsupportedAlgorithmException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnsupportedAlgorithmException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
