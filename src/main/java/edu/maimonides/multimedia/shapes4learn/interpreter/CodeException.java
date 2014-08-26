package edu.maimonides.multimedia.shapes4learn.interpreter;

/**
 * This exception abstracts errors related to source code analysis such as
 * lexical, syntactical and semantic.
 * 
 * @author Matias Giorgio
 * 
 */
public class CodeException extends Exception {

	public CodeException() {
	}

	public CodeException(String message) {
		super(message);
	}
}
