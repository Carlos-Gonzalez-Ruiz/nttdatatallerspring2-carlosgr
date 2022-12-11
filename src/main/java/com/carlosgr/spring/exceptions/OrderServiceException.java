package com.carlosgr.spring.exceptions;

/**
 * NTT Data - Spring - Taller 2
 * 
 * Clase usada para lanzar excepciones al momento de usar OrderService
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public class OrderServiceException extends RuntimeException {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/**
	 * Método constructor de la clase.
	 * 
	 * @param message
	 */
	public OrderServiceException(String message) {
		super(message);
	}

}
