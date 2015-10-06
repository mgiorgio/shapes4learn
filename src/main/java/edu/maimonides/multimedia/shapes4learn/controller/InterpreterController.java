package edu.maimonides.multimedia.shapes4learn.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import edu.maimonides.multimedia.shapes4learn.analysis.LexicalAnalyzer;
import edu.maimonides.multimedia.shapes4learn.analysis.LexicalException;
import edu.maimonides.multimedia.shapes4learn.interpreter.CodeException;
import edu.maimonides.multimedia.shapes4learn.interpreter.Interpreter;
import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;
import edu.maimonides.multimedia.shapes4learn.model.Token;

public class InterpreterController implements Interpreter{
	
	private LexicalAnalyzer la;

	public InterpreterController(LexicalAnalyzer la) {
		super();
		this.la = la;
	}

	@Override
	public void interpret(String code, ShapeAmbient ambient)
			throws CodeException {
		try {
			List<Token> tk = la.analyze(code);
		} catch (LexicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void interpret(InputStream stream, ShapeAmbient ambient)
			throws CodeException, IOException {
		// TODO Auto-generated method stub
		
	}

}
