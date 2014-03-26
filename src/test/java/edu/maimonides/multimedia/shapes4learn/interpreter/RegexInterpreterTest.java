package edu.maimonides.multimedia.shapes4learn.interpreter;

import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;

public class RegexInterpreterTest extends InterpreterTests {

	public RegexInterpreterTest() {
	}

	@Override
	protected Interpreter createInterpreter(ShapeAmbient ambient) {
		RegexInterpreter interpreter = new RegexInterpreter();
		interpreter.setShapeAmbient(ambient);
		return interpreter;
	}

}
