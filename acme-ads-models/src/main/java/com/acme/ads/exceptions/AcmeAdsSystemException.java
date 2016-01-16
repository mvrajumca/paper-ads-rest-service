/**
 * 
 */
package com.acme.ads.exceptions;

/**
 * Exception class to handle JAXB failures.
 * 
 * @author Raju
 */
public class AcmeAdsSystemException extends Exception {

	private static final long serialVersionUID = 1L;

	public AcmeAdsSystemException(String errorMsg) {
		super(errorMsg);
	}
}
