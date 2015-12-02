package edu.maimonides.multimedia.shapes4learn.analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.maimonides.multimedia.shapes4learn.model.AST;
import edu.maimonides.multimedia.shapes4learn.model.Figura;
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
	private AST expG = new AST();
	private ArrayList<Figura> figuras; //pasar al semantico
	
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
		
	//	for (Iterator<String> iterator = sentencias.iterator(); iterator.hasNext();) {
		//	String sent = iterator.next();
			//System.out.println("Setencia: " + sent);
			
		//}
	
		checkSent(tokens);  

		validarArbol(raiz);
		  	
		return raiz;
	}
	
	public void validarArbol(AST raiz2){



<<<<<<< HEAD
		System.out.println("--- Arboles ----- "); 
=======
		System.out.println("--- Árboles ----- "); 
>>>>>>> origin/master

	 	System.out.println("\n"); 

// SETBASE
// +    RECTANGLE
//4  4
	 	 

	 	for (Iterator<AST> it = raiz2.listChildren().iterator(); it.hasNext();) { //SETBASE.LIST = 2 - +List = 2 - 4

		

	 		AST arbol = it.next(); //SETBASE - "+" - 4

	 	

	 		String lexema = arbol.getToken().getClase(); 

	 		 

	 		System.out.println("    " + lexema);   
	 		System.out.println("Hijos: " + arbol.listChildren().size());

	 		 

	 		String s = new String(); 

			

			if (arbol.listChildren().size() != 0 ){
				for(int a = 0 ; a < arbol.listChildren().size(); a++ )
				{
				
				
					String tipo = arbol.getChild(a).getToken().getLexema(); 

					s = s + tipo + "   " ; 

				}
				
				System.out.println(s); 

				System.out.println("\n"); 
			
			
				for(int a = 0 ; a < arbol.listChildren().size(); a++ )
				{
				
					if (arbol.getChild(a).listChildren().size() != 0 ){
						validarArbol(arbol);
					} 
					else{
						String tipo = arbol.getChild(a).getToken().getLexema(); 
						System.out.println(tipo + "  "); 
						System.out.println("\n"); 
					}
				
				} 
			
		 	}
	 	}

<<<<<<< HEAD
		System.out.println("---  Fin Arboles ----- "); 
=======
		System.out.println("---  Fin Árboles ----- "); 
>>>>>>> origin/master

		System.out.println("\n"); 

	
	
	System.out.println ("\n");
	System.out.println ("--- Comienza Analisis semantico ----- ");
	System.out.println ("\n");
	
	for (Iterator<AST> it = raiz2.listChildren().iterator(); it.hasNext();) {
		
	AST arbol = it.next();
		
	String lexema = arbol.getToken().getClase();
	String tipo = arbol.getChild(0).getToken().getLexema();
    String id = arbol.getChild(1).getToken().getLexema();
    
	
    
	if (lexema.equals("crear"))
	{
		Figura figuraNueva = new Figura();
	
		if(figuras.isEmpty()){
			figuraNueva.setClase(tipo);
			figuraNueva.setId(id);
			figuras.add(figuraNueva);
			
			
		}
		
		else
		
		{
			for (Iterator<Figura> iterator = figuras.iterator(); iterator.hasNext();) {
				
				
				
				if(iterator.next().getId().equals(id)){
					
					System.out.printf("Ya existe el ID \"%s\" para otra figura", id);
					System.exit(0);
					
				}
				
				figuraNueva.setClase(tipo);
				figuraNueva.setId(id);
				System.out.println("Se creo una figura.");
			}
			
			figuras.add(figuraNueva);
		}
		
	}
		
		
		
	}
	
	for (Iterator<Figura> iterator1 = figuras.iterator(); iterator.hasNext();) {
		Figura fig = iterator1.next();
		System.out.println("\n");
		
		System.out.printf(" Figura creada: %s Clase %s", fig.getId() , fig.getClase());
		
	}
	
	}
	

public void checkSent(List<Token> tokens){
	
		figuras = new ArrayList<>();
		
		for (iterator = tokens.iterator(); iterator.hasNext();) {
			
			token = (Token) iterator.next();
			
			lookahead = token.getClase();
			
			//Cambiar clase
		
			
			
			linea++;
			System.out.println("\n");
			
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



private void checkPosition(String string) {
	

		AST setposition = new AST();
		setposition.setLinea(linea);
		setposition.setToken(token);
		
		matchSetPosition(string);
		
		AST position_def = new AST();
		position_def.setLinea(linea);
		position_def.setToken(token);
		
		setposition.addChild(position_def);
		
		checkExpresion(lookahead);
		
		matchComa(lookahead);
		
		AST position_def2 = new AST();
		position_def2.setLinea(linea);
		position_def2.setToken(token);
		
		setposition.addChild(position_def2);
		
		checkExpresion(lookahead);
		
		matchIn(lookahead);
		matchShape(lookahead);
		
		AST id = new AST();
		id.setLinea(linea);
		id.setToken(token);
		
		setposition.addChild(id);
		
		matchId(lookahead);
		matchFin(lookahead);
		
		raiz.addChild(setposition);
		

				
	}

private boolean matchComa(String coma) {

	if(coma == "coma"){
		//System.out.println("Es coma");
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	}
	System.out.printf("Vino %s, se esperaba coma.", coma);
	System.exit(0);
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
	System.exit(0);
	return false;
	
}

private void checkRadio(String string) {
	
System.out.println("Se espera: setradius [expression] in circle [id] ;");
		AST setradio = new AST();
		setradio.setLinea(linea);
		setradio.setToken(token);
		
		matchSetRadio(string);
		
		AST radio_def = new AST();
		
		radio_def.setLinea(linea);
		radio_def.setToken(token);
		
		setradio.addChild(radio_def);
		
		checkExpresion(lookahead);
		
		matchIn(lookahead);
		matchCircle(lookahead);
		
		AST id = new AST();
		id.setLinea(linea);
		id.setToken(token);
		
		setradio.addChild(id);
		
		matchId(lookahead);
		matchFin(lookahead);
		
		raiz.addChild(setradio);

				
	}


private boolean matchSetRadio(String string) {
	if(string == "setear radio"){
		System.out.println("Es setRadio");
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	}
	System.out.printf("Vino %s, se esperaba setRadio.", string);
	System.exit(0);
	return false;
		
	}

	//	setcolor [color_def] in shape [id];

	private void checkSetColor(String string) {
		
		System.out.println("Se espera: setcolor [color_def] in shape [id] ;");
		
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
	

				
	}
	
	private boolean matchShape(String string) {
		if(string == "clase shape"){
			System.out.println("Es shape");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba 'shape'", string);
		System.exit(0);
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
		System.exit(0);
		return false;
		
		
	}

	
//	setheight [expression] in rectangle [id] ;
	
	private void checkSetHeight(String string) {
		
		System.out.println("Se espera: setheight [expression] in rectangle [id] ;");
				
				AST setheight = new AST();
				setheight.setLinea(linea);
				setheight.setToken(token);
				
				matchSetHeight(string);
				
				AST height_def = new AST();
				height_def.setLinea(linea);
				height_def.setToken(token);
				
				setheight.addChild(height_def);
				
				checkExpresion(lookahead);
				
				matchIn(lookahead);
				matchRectangle(lookahead);
				
				AST id = new AST();
				id.setLinea(linea);
				id.setToken(token);
				
				setheight.addChild(id);
				
				matchId(lookahead);
				matchFin(lookahead);
				
				raiz.addChild(setheight);
		

						
			}


	
	private boolean matchSetHeight(String string) {
		if(string == "setear altura"){
			System.out.println("Es setHeight");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba setHeight.", string);
		System.exit(0);
		return false;
		
	}

//  setbase [expression] in rectangle [id] ;
	
	private void checkSetBase(String string) {
		
		System.out.println("Se espera: setbase [expression] in rectangle [id] ;");		
				
			AST setbase = new AST();
			setbase.setLinea(linea);
			setbase.setToken(token);
		
			matchSetBase(string);

			setbase.addChild(checkExpresion(lookahead));
			
			matchIn(lookahead);
			
			matchRectangle(lookahead);
		
			
			AST id = new AST();
			id.setLinea(linea);
			id.setToken(token);
			
			
			setbase.addChild(id);
			
			matchId(lookahead);
			matchFin(lookahead);
				
			raiz.addChild(setbase);
						
			}
	

	private boolean matchSetBase(String string) {
		if(string == "setear base"){
			System.out.println("Es setBase");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		}
		System.out.printf("Vino %s, se esperaba setBase.", string);
		System.exit(0);
		return false;
		
	}

	private AST checkExpresion(String string) {
		//System.out.println("CHECK EXPRESION");
	
		AST tnode = checkTermino(string);
		AST trnode = checkTerminoR(lookahead);
		
	return createNodo(tnode,trnode);
}

private AST createNodo(AST tnode, AST trnode) {
	
	AST op = new AST();
	
	AST nodeI = tnode;
	
	//System.out.println(tnode.getToken().getLexema() + " " + trnode.getToken().getLexema());
	if (trnode != null){
	if (trnode.getToken().getClase()=="Adicion"){
		
	
	op.setToken(trnode.getToken());
	op.setLinea(trnode.getLinea());
	
	
	System.out.println(tnode.getChild(0).getToken().getLexema());
	AST nodeD = trnode.getChild(0);
	
	op.addChild(nodeI);
	op.addChild(nodeD);
	
	return op;
	
	}
	
	if (trnode.getToken().getClase()=="Producto"){
		
		
	op.setToken(trnode.getToken());
	op.setLinea(trnode.getLinea());
	AST nodeD = trnode.getChild(0);
	
	op.addChild(nodeI);
	op.addChild(nodeD);
	
	return op;
	
	}
	}
		return nodeI;
	}

private AST checkTerminoR(String string) {
	
	AST fnode = new AST();
	
	
	System.out.println("CHECK TERMINO R");
	if(matchAdicion(string)){
		
		AST tnode = checkTermino(lookahead);
		AST trnode = checkTerminoR(lookahead);
		
		return createNodo(tnode, trnode);
	}
	else{
		
		if (string=="Numero" || string == "Parentesis A") {
			fnode = checkFactor(string);
			return fnode;			
		}else {
			return null;
		}
		
		
			
	}	
	
	
		
		
}

private AST checkFactor(String string) {

	AST fnode = new AST();
	System.out.println("CHECK FACTOR");
	if (string == "Numero"){
		
		
		fnode.setLinea(linea);
		fnode.setToken(token);
		
		matchNumero(string);
		
		}
	else{
		if(matchAbroP(string)){
	
		fnode = checkExpresion(lookahead);
		
		matchCierroP(lookahead);
		
		}
		
		
		
	}
	return fnode;
	
}

private boolean matchNumero(String string) {
	if(string == "Numero"){
		System.out.println("Es Numero.");
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	} else {
		
		return false;
	}
	
}

private boolean matchAdicion(String string) {
	
	if(string == "Adicion"){
		System.out.println("Es Adicion.");
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
		
	}
	return false;
	
}

private boolean matchProducto(String string) {
	if(string == "Producto"){
		
		System.out.println("Es Producto.");
		token = (Token) iterator.next();
		lookahead = token.getClase(); 
		return true;
	} else {
		return false;
	}
	
}

//EXP 
//TERM = 4*4
//TERMR+4


private AST checkTermino(String string) {
	System.out.println("CHECK TERMINO");
	AST fnode = checkFactor(string); //4
	AST frnode = checkFactorR(lookahead); //*4
	
	
	return createNodo(fnode, frnode);
	
}

private AST checkFactorR(String string) {
	System.out.println("CHECK FACTOR R");
	AST frnode = new AST();
	frnode = null;
	

		if(matchAbroP(string)){
		
		
		
		frnode = checkExpresion(lookahead);
		matchCierroP(lookahead);
		
		
		
	}
		else {
			
			if(matchProducto(string))
			{
				
				
				AST fnode = checkFactor(lookahead);
				frnode = checkFactorR(lookahead);
				return createNodo(fnode, frnode);
			}
			else {
				if(matchNumero(string)){
				frnode.setLinea(linea);
				frnode.setToken(token);
				}
				
			}
			

		
		}
		
		return frnode;
		
}

private boolean matchCierroP(String string) {
	if(string == "Parentesis C"){
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	}
	System.out.printf("Vino %s, se esperaba ')'. \n", string);
	System.exit(0);
	return false;
	
}
//setbase ( 4 ) in rectangle id ;

private boolean matchAbroP(String string) {
	if(string == "Parentesis A"){
		token = (Token) iterator.next();
		lookahead = token.getClase();
		return true;
	}
	
	return false;
	
}
		
	

	private void matchFin(String string) {
		
		if (string == "fin de sentencia"){
			
			if (iterator.hasNext()){
			
			System.out.println("[;] Fin de sentencia");
			}
			else {
				System.out.println("[;] Fin de sentencia");
				System.out.println("\n");
				System.out.println("Terminaron las sentencias a analizar");
				System.out.println("\n");
				
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
		System.exit(0);
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
		System.exit(0);
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
		
		
	}
		
		
	

	private boolean matchId(String string) {
		
		if(string == "ID"){
			System.out.println("Es ID.");
			token = (Token) iterator.next();
			lookahead = token.getClase();
			return true;
		} else {
			System.out.printf("Vino %s, se esperaba un ID valido \n ", string);
			System.exit(0);
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
				System.exit(0);
				
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
		System.exit(0);
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
		System.exit(0);
		return false;
		
	}
}
