package com.socialMedia.exception;
/**
 * Simple runtime business Exception, can be modified in later stages, we can introduce @ExceptionHanler in case we add RESTful API's
 * @author mayankjalotra
 * @since v1.0
 */
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1850877286270920725L;
	
	public BusinessException() {
        super();
    }
	
	/**
	 * Constructs a new business exception with the specified detail message.
	 * @param message the detail message. 
	 */
	public BusinessException(String message) {
        super(message);
    }
}
