/**
 * 
 */
package edu.maimonides.multimedia.shapes4learn.analysis;

/**
 * An Exception to be thrown when the {@link LexicalAnalyzer} finds an error.
 * 
 * @author mgiorgio
 * 
 */
public class LexicalException extends Exception {

	/**
	 * 
	 */
	public LexicalException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public LexicalException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public LexicalException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LexicalException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LexicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
