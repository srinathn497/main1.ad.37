package main;


@SuppressWarnings("serial")
public class duplicateException extends Exception {

	/**
	 * 
	 */
	public duplicateException() {
		super();

	}

	/**
	 * @param message
	 */
	public duplicateException(final String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public duplicateException(final Throwable cause) {
		super(cause);

	}

}