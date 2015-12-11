package edu.maimonides.multimedia.shapes4learn;

import javax.swing.JOptionPane;

import edu.maimonides.multimedia.shapes4learn.analysis.LexicalAnalyzer;
import edu.maimonides.multimedia.shapes4learn.analysis.SyntacticAnalyzer;
import edu.maimonides.multimedia.shapes4learn.controller.InterpreterController;
import edu.maimonides.multimedia.shapes4learn.gui.InterpreterFrame;
import edu.maimonides.multimedia.shapes4learn.interpreter.Interpreter;
import edu.maimonides.multimedia.shapes4learn.model.impl.BasicShapeAmbient;

/**
 * 
 */

/**
 * @author matias
 * 
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String classname = null;
		if (args.length == 0) {
			JOptionPane.showMessageDialog(null, "Using Test Interpreter", "Warning", JOptionPane.WARNING_MESSAGE);
			classname = "edu.maimonides.multimedia.shapes4learn.interpreter.RegexInterpreter";
		} else {
			classname = args[0];
		}
		InterpreterFrame frame;
		try {
			LexicalAnalyzer lexAn = new LexicalAnalyzer();
			
			SyntacticAnalyzer synAn = new SyntacticAnalyzer();
			
			frame = new InterpreterFrame(createInterpreter(classname), new BasicShapeAmbient(), lexAn, synAn );
			frame.init();
			frame.setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Interpreter createInterpreter(String classname) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Class<Interpreter> clazz = (Class<Interpreter>) Class.forName(classname);

		return clazz.newInstance();
	}
}