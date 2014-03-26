package edu.maimonides.multimedia.shapes4learn.model.exceptions;

import edu.maimonides.multimedia.shapes4learn.model.Shape;

/**
 * Any issue related to {@link Shape} manipulation will be abstracted under this
 * exception.
 * 
 * @author Matias Giorgio
 * 
 */
public class ShapeManipulationException extends Exception {

	public ShapeManipulationException() {
	}

	public ShapeManipulationException(String message) {
		super(message);
	}
}