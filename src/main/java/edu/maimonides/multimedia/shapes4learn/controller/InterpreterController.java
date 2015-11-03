package edu.maimonides.multimedia.shapes4learn.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import edu.maimonides.multimedia.shapes4learn.analysis.LexicalAnalyzer;
import edu.maimonides.multimedia.shapes4learn.analysis.LexicalException;
import edu.maimonides.multimedia.shapes4learn.analysis.SyntacticAnalyzer;
import edu.maimonides.multimedia.shapes4learn.analysis.SyntacticException;
import edu.maimonides.multimedia.shapes4learn.interpreter.CodeException;
import edu.maimonides.multimedia.shapes4learn.interpreter.Interpreter;
import edu.maimonides.multimedia.shapes4learn.model.AST;
import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;
import edu.maimonides.multimedia.shapes4learn.model.Token;

public class InterpreterController implements Interpreter{
	
	private LexicalAnalyzer la;
	private List<Token> tk;
	private SyntacticAnalyzer sa;

	public InterpreterController(LexicalAnalyzer la, SyntacticAnalyzer sa) {
		super();
		this.la = la;
		this.sa = sa;
	}

	@Override
	public void interpret(String code, ShapeAmbient ambient)
			throws CodeException {
		try {
			 tk = la.analyze(code);
		} catch (LexicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			AST ast = sa.analyze(tk);
		} catch (SyntacticException e) {
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
