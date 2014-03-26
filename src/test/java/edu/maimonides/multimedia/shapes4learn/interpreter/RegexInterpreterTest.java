package edu.maimonides.multimedia.shapes4learn.interpreter;

public class RegexInterpreterTest extends InterpreterTests {

	public RegexInterpreterTest() {
	}

	@Override
	protected Interpreter createInterpreter() {
		return new RegexInterpreter();
	}

}
