package edu.maimonides.multimedia.shapes4learn.analysis;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import edu.maimonides.multimedia.shapes4learn.model.Token;

/**
 * This class is responsible for the first part of the interpreter: lexical
 * analysis. It will be implemented by the students to perform the proper
 * operations.
 * 
 * @author Matias Giorgio
 * 
 */
public class LexicalAnalyzer {

	public List<Token> analyze(String code) throws LexicalException {
		
		String[][] reservada = new String[20][20];
		//String[] aux;
		boolean validoNum=false;
		//boolean validoId=true;
		boolean ExpArit=false;
		boolean reservada1=false;
		boolean id=false;
		
		// Completo la matriz token (lexemas - clase)
		
		reservada[0][0] = "create";       reservada[0][1] = "crear";
		
		reservada[1][0] = "rectangle";    reservada[1][1] = "ShapeRectangulo";
		
		reservada[2][0] = "circle"; 	  reservada[2][1] = "ShapeCirculo";
		
		reservada[3][0] = ";"; 			  reservada[3][1] = "fin de sentencia";
		
		reservada[4][0] = "setbase";      reservada[4][1] = "setear base";
		
		reservada[5][0] = "sethight";     reservada[5][1] = "setear altura";
		
		reservada[6][0] = "setcolor";     reservada[6][1] = "setear color";
		
		reservada[7][0] = "setradius";    reservada[7][1] = "setear radio";
		
		reservada[8][0] = "setposition";  reservada[8][1] = "setear posicion";
		
		reservada[9][0] = "shape";       reservada[9][1] = "clase shape";
		
		reservada[10][0] = ",";           reservada[10][1] = "separador de expresiones";
		
		reservada[11][0] = "in";           reservada[11][1] = "'in'";
		
		List<Token> tokens = new LinkedList<>();
		
		// Separo los lexemas
		String delimitadores= "[\\ \\	\\  \\   \\    \\		]";
		String lexemas[] = code.split(delimitadores);
		
		//Recorro los lexemas y encuentro las Lexemas reservadas del lenguaje
		for(int i=0; i< lexemas.length; i++) {
			
			Token tempToken = new Token();
			reservada1=false;
			validoNum=false;
			//boolean validoId=true;

			reservada1=false;
			id=false;
			
			//System.out.println("\nPosicion: " + i + " <><> Lexema que ingresa: " + lexemas[i]); 
			
			//System.out.println("Token: ");
			
			for (int j=0;j<=11;j++)
			{
				
				if (lexemas[i].equals(reservada[j][0]))
				{
					// Cuando lo encuentro, como se pasa a la linkedlisto token????
					
					reservada1=true;
					
					tempToken.lexema = reservada[j][0];
					tempToken.clase = reservada [j][1];
				}
			}					
					// si no es Lexema reservada
					
					int x=0;
					
					// veo si es numero
				    for (;x<lexemas[i].length() && Character.isDigit(lexemas[i].charAt(x)) ;x++)
				     	{ 
				    		validoNum=true;
				        }
				    
				    if (validoNum) {
				   
				    	tempToken.lexema = lexemas[i];
			        	tempToken.clase = "Numero";
						
					} else {
						if (reservada1==false)
						{
						tempToken.lexema = lexemas[i];
			        	tempToken.clase = "Lexema desconocido";
						}
					}
				    
				    
				    //Expresion aritmetica

				    int f=0;
				    char ant='a';		    
							    
				    for (;(f<lexemas[i].length()) && (reservada1==false) && ExpArit==true;f++)
			        { 

			        	if (Character.isDigit(lexemas[i].charAt(f)) || lexemas[i].charAt(f) == '-' ||
	        				lexemas[i].charAt(f) == '*' || lexemas[i].charAt(f) == '/' 
	        				|| lexemas[i].charAt(f) == '(' || lexemas[i].charAt(f) == ')'
	        				|| (lexemas[i].charAt(f)) == '+')
			        			{
			        				ExpArit=true;
			        			} else
			        			
			        			{
			        				ExpArit=false;
			        			}
			        }
				    
			        if (ExpArit)
			        {
			        	tempToken.lexema = lexemas[i];
			        	tempToken.clase = "Expresion Aritmetica";

			        }else
			        { if (reservada1 == false && validoNum==false)
			        	{
			        	tempToken.lexema = lexemas[i];
			        	tempToken.clase = "Lexema desconocido";
			        	}
			        }
			        
				    //ID bien
			        
			        //System.out.println("Entra en ID el lexema " + lexemas[i]); 
			        
			       /* int t=0;
			        
				    for (;t<lexemas[t].length() && Character.isLetter(lexemas[t].charAt(t))  && reservada1==false ;t++)
			        {
					    tempToken.lexema = lexemas[t];
					    tempToken.clase = "ID";
					   // tokens.add(tempToken);	
			        }*/
			        
			        if (lexemas[i].matches("([a-z]|[A-Z]|\\s)+") && reservada1==false) {
			        	tempToken.lexema = lexemas[i];
					    tempToken.clase = "ID";
					    id=true;
					}  
				    	        
				    //color_def

				    //System.out.println("Entra en Color_def el lexema " + lexemas[i]); 
				    

				    if ( lexemas[i].charAt(0)=='#')
				    {
				    	if (lexemas[i].substring(1).matches("([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")) {
				    		 tempToken.lexema = lexemas[i];
							 tempToken.clase = "color_def";
						}else {
							tempToken.lexema = lexemas[i];
							tempToken.clase = "Lexema desconocido";
						}
				   	}
				    				    
				    //Hexadecimal
				    //System.out.println("Entra en hexadecimal el lexema " + lexemas[i]); 

				    //System.out.println("Token lexema: " + i + " " + tempToken.lexema + " Token clase: " + tempToken.clase);
				    tokens.add(i,tempToken);				    	
			}
		
		// Se imprimien los token (lexema, clase)
		
		for (Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
			Token token = (Token) iterator.next();
			System.out.println("Lexema: " + token.lexema + "			Clase: " + token.clase);
		}
		  	
		return tokens;
	}
}
