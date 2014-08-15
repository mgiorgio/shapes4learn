package edu.maimonides.multimedia.shapes4learn;

import javax.swing.JOptionPane;

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
		if (args.length == 0) {
			JOptionPane.showMessageDialog(null, "An Interpreter implementation must be passed", "Error", JOptionPane.ERROR_MESSAGE);
		}
		InterpreterFrame frame;
		try {
			frame = new InterpreterFrame(createInterpreter(args[0]), new BasicShapeAmbient());
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