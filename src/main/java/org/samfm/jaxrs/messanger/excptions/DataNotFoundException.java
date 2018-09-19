package org.samfm.jaxrs.messanger.excptions;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5829025715598173505L;
	
	
	public DataNotFoundException(String exception) {
		super(exception);
	}

}
