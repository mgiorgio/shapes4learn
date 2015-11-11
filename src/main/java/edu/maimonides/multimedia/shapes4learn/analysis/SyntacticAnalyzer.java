package edu.maimonides.multimedia.shapes4learn.analysis;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.maimonides.multimedia.shapes4learn.model.AST;
import edu.maimonides.multimedia.shapes4learn.model.Token;

/**
 * This class is responsible for the second part of the interpreter: syntactic
 * analysis. It will be implemented by the students to perform the proper
 * operations.
 * 
 * @author Matias Giorgio
 * 
 */
public class SyntacticAnalyzer {
	
	private int linea=0;
	private String sentencia;
	private String lookahead;
	private Token token;
	private Iterator<Token> iterator;
	private AST raiz = new AST();

	public SyntacticAnalyzer() {
	}

	public AST analyze(List<Token> tokens) throws SyntacticException {
		
		List<String> sentencias = new LinkedList<>();

		sentencia = new String();
		
		
		for (Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
			Token token = (Token) iterator.next();
			
			if ((token.lexema.charAt(0) == ';')){
				
				sentencias.add(sentencia + ';');
				
				sentencia = new String();
				
				
			}else{
				sentencia = sentencia.concat(' ' +token.lexema);	
				
				
				
				}
			
		}
		
		for (Iterator<String> iterator = sentencias.iterator(); iterator.hasNext();) {
			String sent = iterator.next();
			System.out.println("Setencia: " + sent);
			
		}
	
		checkSent(tokens);  
		
		
		  	
		return raiz;
	}
	
public void checkSent(List<Token> tokens){
		
		for (iterator = tokens.iterator(); iterator.hasNext();) {
			
			token = (Token) iterator.next();
			
			lookahead = token.getClase();
			
			//Cambiar clase
		
			System.out.println("\n");
			System.out.println("---- Comienza el análisis de una sentencia -----\n");
			System.out.println("\n");
			
			linea++;
			
			if (lookahead == "crear"){
				checkCreate(lookahead);
			}
		

			if (lookahead == "setear color"){
				checkSetColor(lookahead);
			}
			
			if (lookahead == "setear base"){
				checkSetBase(lookahead);
			}
		
			if (lookahead == "setear altura"){
				checkSetHeight(lookahead);
			}
			
			if(lookahead == "setear radio"){
				checkRadio(lookahead);
			}
		
			if(lookahead == "setear posicion"){
				checkPosition(lookahead);
			}
		}
		
	}


//  setposition [expression],[expression] in shape [id] ;

private void checkPosition(String string) {
	System.out.println("setposition [expression],[expression] in shape [id] ;");
	matchSetPosition(string);
	checkExpresion(lookahead);
	matchComa(lookahead);
	checkExpresion(lookahead);
	matchIn(lookahead);
	matchShape(lookahead);
	matchId(lookahead);
	matchFin(lookahead);
	
	
	
	
}


//	setradius [expression] in circle [id] ;

private boolean matchComa(String string) {
	if(string == "separador de expresiones"){
		System.out.println("Es Coma");
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	}
	System.out.println("No es Coma. Error");
	System.out.close();
	return false;
	
}

private boolean matchSetPosition(String string) {
	if(string == "setear posicion"){
		System.out.println("Es setPosition");
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	}
	System.out.printf("Vino %s, se esperaba setPosition.", string);
	System.out.close();
	return false;
	
}

private void checkRadio(String string) {
	System.out.println("setradius [expression] in circle [id] ;");
	matchSetRadio(string);
	checkExpresion(lookahead);
	matchIn(lookahead);
	matchCircle(lookahead);
	matchId(lookahead);
	matchFin(lookahead);
	
}

private boolean matchSetRadio(String string) {
	if(string == "setear radio"){
		System.out.println("Es setRadio");
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	}
	System.out.printf("Vino %s, se esperaba setRadio.", string);
	System.out.close();
	return false;
		
	}

	//	setcolor [color_def] in shape [id];

	private void checkSetColor(String string) {
		
		System.out.println("setcolor [color_def] in shape [id] ;");
		
		AST setcolor = new AST();
		setcolor.setLinea(linea);
		setcolor.setToken(token);
		
		matchSetColor(string);
		
		AST color_def = new AST();
		color_def.setLinea(linea);
		color_def.setToken(token);
		
		setcolor.addChild(color_def);
		
		matchColorDef(lookahead);
		
		matchIn(lookahead);
		matchShape(lookahead);
		
		AST id = new AST();
		id.setLinea(linea);
		id.setToken(token);
		
		setcolor.addChild(id);
		
		matchId(lookahead);
		matchFin(lookahead);
		
		raiz.addChild(setcolor);
		String a = raiz.getChild(1).getToken().getLexema();
	    String b = raiz.getChild(1).getChild(0).getToken().getLexema();
	    String c = raiz.getChild(1).getChild(1).getToken().getLexema();
		
	    System.out.printf("Muestro arbol de set color: ");
	    
		System.out.printf("-  1: %s", a);
		System.out.printf("- 2: %s", b);
		System.out.printf("- 3: %s", c);

				
	}
	
	private boolean matchShape(String string) {
		if(string == "clase shape"){
			System.out.println("Es shape");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba 'shape'", string);
		System.out.close();
		return false;
		
		
	}

	private boolean matchIn(String string) {
		if(string == "in"){
			System.out.println("Es in");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba 'in'", string);
		System.out.close();
		return false;
		
		
	}

	
//	setheight [expression] in rectangle [id] ;
	
	private void checkSetHeight(String string) {
		System.out.println("setheight [expression] in rectangle [id] ;");
		matchSetHeight(string);		
		checkExpresion(lookahead);
		matchIn(lookahead);
		matchRectangle(lookahead);
		matchId(lookahead);
		matchFin(lookahead);
		
	}
	

	
	private boolean matchSetHeight(String string) {
		if(string == "setear altura"){
			System.out.println("Es setHeight");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba setHeight.", string);
		System.out.close();
		return false;
		
	}

//  setbase [expression] in rectangle [id] ;
	
	private void checkSetBase(String string) {
		
		System.out.println("setbase [expression] in rectangle [id] ;");
		matchSetBase(string);		
		checkExpresion(lookahead);
		matchIn(lookahead);
		matchRectangle(lookahead);
		matchId(lookahead);
		matchFin(lookahead);
		
	}

	private boolean matchSetBase(String string) {
		if(string == "setear base"){
			System.out.println("Es setBase");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba setBase.", string);
		System.out.close();
		return false;
		
	}

	private void checkExpresion(String string) {
		
		if (string == "Numero"){
			System.out.println("Es numero");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			checkExpresion(lookahead);
		} 
		
	
			
		
	}

	private void matchFin(String string) {
		
		if (string == "fin de sentencia"){
			
			if (iterator.hasNext()){
			
			System.out.println("[;] Fin de sentencia");
			}
			else {
				System.out.println("[;] Fin de sentencia");
				System.out.println("Terminaron las sentencias a analizar");
				
			}
		}
		
	}

	private boolean matchSetColor(String string) {
		if(string == "setear color"){
			System.out.println("Es setColor");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba setcolor \n", string);
		System.out.close();
		return false;
		
	}

	private boolean matchColorDef(String string) {
		if(string == "color_def"){
		System.out.println("Es un color");
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	}
		System.out.printf("Vino %s, se esperaba un color del tipo #AAA111 \n", string);
		System.out.close();
		return false;
	
		
	}

//	create rectangle|circle [id];
	
	private void checkCreate(String string) {
		
		System.out.println("Se espera: create rectangle|circle [id]");
		AST create = new AST();
		create.setLinea(linea);
		create.setToken(token);
		
		matchCreate(string);
		
		AST shape = checkShape(lookahead);
		create.addChild(shape);
		
		AST id = new AST();
		id.setLinea(linea);
		id.setToken(token);
		matchId(lookahead);
		
		create.addChild(id);
		
		matchFin(lookahead);
		
		raiz.addChild(create);
		String a = raiz.getChild(0).getToken().getLexema();
	    String b = raiz.getChild(0).getChild(0).getToken().getLexema();
	    String c = raiz.getChild(0).getChild(1).getToken().getLexema();
	    
	    System.out.printf("Muestro arbol de crear: ");
		
		System.out.printf("-  1: %s", a);
		System.out.printf("- 2: %s", b);
		System.out.printf("- 3: %s", c);
	}
		
		
	

	private boolean matchId(String string) {
		
		if(string == "ID"){
			System.out.println("Es ID.");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		} else {
			System.out.printf("Vino %s, se esperaba un ID valido \n ", string);
			System.out.close();
			return false;
		}
		
	}

	private AST checkShape(String string) {
		
		AST figura = new AST();
		figura.setLinea(linea);
		figura.setToken(token);
		
		if (string == "ShapeCirculo"){
			System.out.println("Es circle");
			matchCircle(lookahead);
		}else {
			if (string == "ShapeRectangulo"){
				System.out.println("Es rectangle");
				matchRectangle(lookahead);
				
			} else {
				System.out.printf("Vino %s, se esperaba una figura \n ", string);
				System.out.close();
				
			}
		
		}
		return figura;

	}

	private boolean matchRectangle(String string) {
		if(string == "ShapeRectangulo"){
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		} else {
		System.out.printf("Vino %s, se esperaba un rectangulo \n ", string);
			System.out.close();
			return false;
		}
		
	}

	private boolean matchCircle(String string) {
		if(string == "ShapeCirculo"){
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		
		System.out.close();
		return false;
		
		
	}

	private boolean matchCreate(String string) {
		if(string == "crear"){
			System.out.println("Es create");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba 'create' \n ", string);
		System.out.close();
		return false;
		
	}
}