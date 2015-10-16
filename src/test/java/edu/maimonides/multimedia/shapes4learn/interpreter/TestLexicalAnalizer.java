package edu.maimonides.multimedia.shapes4learn.interpreter;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import edu.maimonides.multimedia.shapes4learn.analysis.LexicalAnalyzer;
import edu.maimonides.multimedia.shapes4learn.analysis.LexicalException;
import edu.maimonides.multimedia.shapes4learn.model.Token;

public class TestLexicalAnalizer {

	@Test
	public void test() {
		
		String code1 = "create circle micirculo ; "
				+ "setradius 5 + 5 in circle micirculo ; "
				+ "setcolor #aA1234 in shape micirculo ;";
		
		//String code1 = "create";
		
		List<Token> tokenValida = new LinkedList<>();
		
		LexicalAnalyzer lex = new LexicalAnalyzer();

		try {
			
			List<Token> tokens = lex.analyze(code1);
			
			System.out.println("	   TestLexicalAnalizer: \n");
			//Inicializar prueba 1
			Token tok = new Token();
			tok.setLexema("create");tok.setClase("crear");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("circle");tok.setClase("ShapeCirculo");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("micirculo");tok.setClase("ID");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema(";");tok.setClase("fin de sentancia");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("setradius");tok.setClase("setear radio");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("5");tok.setClase("Numero");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("+");tok.setClase("Operador suma");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("5");tok.setClase("Numero");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("in");tok.setClase("'in'");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("circle");tok.setClase("ShapeCirculo");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("micirculo");tok.setClase("ID");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema(";");tok.setClase("fin de sentencia");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("setcolor");tok.setClase("setear color");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("#aA1234");tok.setClase("color_def");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("in");tok.setClase("'in'");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("shape");tok.setClase("clase shape");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("micirculo");tok.setClase("ID");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema(";");tok.setClase("fin de sentancia");tokenValida.add(tok);

			boolean soniguales = false;
			
			for (int i = 0; i < tokens.size() || i < tokenValida.size(); i++) {

				if (tokens.get(i).getLexema().equals(tokenValida.get(i).getLexema())
						&& tokens.get(i).getClase().equals(tokenValida.get(i).getClase())) {
					
					soniguales=true;
				}
			}
			
			assertTrue("Lexema Correcto ", soniguales);
			
			for (Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
				Token token = (Token) iterator.next();
				System.out.println("Lexema: " + token.lexema + "			Clase: " + token.clase);
			}
			
			}catch(LexicalException e) {
			// TODO Auto-generated catch block
			fail("Lanzada excepcion no esperada Tokeb caso 1");
			e.printStackTrace();
		}

	}
	
	@Test
	public void test2() {
		
		String code1 = "create cir4cle micirculo ; #";
		
		List<Token> tokenValida = new LinkedList<>();
		
		LexicalAnalyzer lex = new LexicalAnalyzer();

		try {
			
			List<Token> tokens = lex.analyze(code1);
			
			System.out.println("\n");
			System.out.println("	   TestLexicalAnalizer: \n");
			
			//Inicializar prueba 2
			Token tok = new Token();
			tok.setLexema("create");tok.setClase("crear");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("cir4cle");tok.setClase("Lexema desconocido");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("micirculo");tok.setClase("ID");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema(";");tok.setClase("fin de sentancia");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("#");tok.setClase("Lexema desconocido");tokenValida.add(tok);
			
			boolean soniguales = false;
			
			for (int i = 0; i < tokens.size() || i < tokenValida.size(); i++) {

				if (tokens.get(i).getLexema().equals(tokenValida.get(i).getLexema())
						&& tokens.get(i).getClase().equals(tokenValida.get(i).getClase())) {
					
					soniguales=true;
				}
			}
			
			assertTrue("Lexema Correcto ", soniguales);

			
			for (Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
				Token token = (Token) iterator.next();
				System.out.println("Lexema: " + token.lexema + "			Clase: " + token.clase);
			}
			
			}catch(LexicalException e) {
			// TODO Auto-generated catch block
			fail("Lanzada excepcion no esperada Tokeb caso 1");
			e.printStackTrace();
		}

	}
	
	@Test
	public void test3() {
		
		String code1 = "setradius ( 5 + 5 ) * 3 in circle micirculo ;";
		
		List<Token> tokenValida = new LinkedList<>();
		
		LexicalAnalyzer lex = new LexicalAnalyzer();

		try {
			
			List<Token> tokens = lex.analyze(code1);
			
			System.out.println("\n");
			System.out.println("	   TestLexicalAnalizer: \n");
			
			//Inicializar prueba 3
			Token tok = new Token();
			tok.setLexema("setradius");tok.setClase("setear radio");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("(");tok.setClase("Parentesis de Apertura");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("5");tok.setClase("Numero");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("+");tok.setClase("Operador suma");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("5");tok.setClase("Numero");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema(")");tok.setClase("Parentesis de Apertura");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("*");tok.setClase("Operador multiplicar");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("3");tok.setClase("Numero");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("in");tok.setClase("`in`");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("circle");tok.setClase("ShapeCirculo");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema("micirculo");tok.setClase("ID");tokenValida.add(tok);
			tok = new Token();
			tok.setLexema(";");tok.setClase("fin de sentancia");tokenValida.add(tok);
			
			boolean soniguales = false;
			
			for (int i = 0; i < tokens.size() || i < tokenValida.size(); i++) {

				if (tokens.get(i).getLexema().equals(tokenValida.get(i).getLexema())
						&& tokens.get(i).getClase().equals(tokenValida.get(i).getClase())) {
					
					soniguales=true;
				}
			}
			
			assertTrue("Lexema Correcto ", soniguales);

			
			for (Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
				Token token = (Token) iterator.next();
				System.out.println("Lexema: " + token.lexema + "			Clase: " + token.clase);
			}
			
			}catch(LexicalException e) {
			// TODO Auto-generated catch block
			fail("Lanzada excepcion no esperada Tokeb caso 1");
			e.printStackTrace();
		}

	}

}
