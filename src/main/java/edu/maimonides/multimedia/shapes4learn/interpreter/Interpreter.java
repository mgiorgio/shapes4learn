package edu.maimonides.multimedia.shapes4learn.interpreter;

import java.io.IOException;
import java.io.InputStream;

import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;

/**
 * This class is the entry-point for the Shape4Learn Interpreter and define its
 * operations. They are very simple as this class is only intended to
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
	 * @param ambient
	 *            The {@link ShapeAmbient} where the code will be interpreted.
	 */
	public void interpret(String code, ShapeAmbient ambient) throws CodeException;

	/**
	 * Interprets a source as a stream. Characters are read on demand and
	 * process. The implementer decides if they will be read one by one or in
	 * blocks.
	 * 
	 * @param stream
	 *            The {@link InputStream} that provides the source code.
	 * @param ambient
	 *            The {@link ShapeAmbient} where the code will be interpreted.
	 * @throws IOException
	 *             If there is an issue accessing the stream.
	 */
	public void interpret(InputStream stream, ShapeAmbient ambient) throws CodeException, IOException;
}