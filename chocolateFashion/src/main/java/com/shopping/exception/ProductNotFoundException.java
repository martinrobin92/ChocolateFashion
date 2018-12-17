package com.shopping.exception;

import java.io.Serializable;

import org.omg.CORBA.Current;

public class ProductNotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String message;
	
	public  ProductNotFoundException() {
		this("Product Not Found");
	}

	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ":" + message;
	}
public String getMessage() {
	return message;
}
}
