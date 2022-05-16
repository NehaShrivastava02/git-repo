package com.springboot.exception;

public class EnquiryNotFoundException extends RuntimeException{
	
	public EnquiryNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}

}
