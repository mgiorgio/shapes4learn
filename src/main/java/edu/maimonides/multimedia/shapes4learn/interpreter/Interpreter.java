package edu.maimonides.multimedia.shapes4learn.interpreter;

import java.io.InputStream;

/**
 * This interface is the entry-point for the Shape4Learn Interpreter and define
 * its operations. They are very simple as this interface is only intended to
 * communicate the input with the Model.
 * 
 * @author Matias Giorgio
 * 
 */
public interface Interpreter {

	/**
	 * Interprets an entire source code.
	 * 
	 * @param code
	 *            A {@link String} representing the entire source code.
	 */
	public void interpret(String code);

	/**
	 * Interprets a source as a stream. Characters are read on demand and
	 * process. The implementer decides if they will be read one by one or in
	 * blocks.
	 * 
	 * @param stream
	 *            The {@link InputStream} that provides the source code.
	 */
	public void interpret(InputStream stream);
}