package edu.maimonides.multimedia.shapes4learn;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		JFrame mainFrame = new JFrame("Shape4Learn");

		BorderLayout layout = new BorderLayout();
		JPanel mainPanel = createMainPanel(layout);

		mainFrame.getContentPane().add(mainPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	private static JPanel createMainPanel(BorderLayout layout) {
		JPanel mainPanel = new JPanel(layout);
		
		JTextArea instructionsArea = new JTextArea("ABC");
		
		mainPanel.add(instructionsArea, BorderLayout.WEST);
		
		JPanel drawingPanel = new JPanel();
		
		mainPanel.add(drawingPanel, BorderLayout.EAST);
		
		return mainPanel;
	}
}