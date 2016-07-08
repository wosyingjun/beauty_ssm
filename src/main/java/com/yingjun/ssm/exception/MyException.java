package com.yingjun.ssm.exception;
/**
 * 
 * @author yingjun
 *
 */
public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
    
    

}
