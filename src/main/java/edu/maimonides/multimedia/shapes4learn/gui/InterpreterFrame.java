package edu.maimonides.multimedia.shapes4learn.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import edu.maimonides.multimedia.shapes4learn.interpreter.CodeException;
import edu.maimonides.multimedia.shapes4learn.interpreter.Interpreter;
import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;

public class InterpreterFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4215453676530842137L;

	private JTextArea code;

	private ShapesPanel shapesPanel;

	private ShapeAmbient ambient;

	private Interpreter interpreter;

	private JTextArea console;

	private ShapesDashboard dashboard;

	private JMenuBar menuBar;

	public InterpreterFrame(Interpreter interpreter, ShapeAmbient ambient) {
		this.ambient = ambient;
		this.interpreter = interpreter;
		code = new JTextArea("Code here...");
		shapesPanel = new ShapesPanel();
		shapesPanel.setAmbient(ambient);
		console = new JTextArea();
		menuBar = new JMenuBar();
		dashboard = new ShapesDashboard(this.ambient);
	}

	public void init() {
		this.setTitle("Shape4Learn");
		final JSplitPane codeShapesSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JScrollPane codeScrollPane = new JScrollPane(code);
		codeScrollPane.setBorder(BorderFactory.createTitledBorder("Code"));
		codeShapesSplitPane.add(codeScrollPane);
		codeShapesSplitPane.add(shapesPanel);

		JSplitPane consoleSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		consoleSplitPane.add(codeShapesSplitPane);
		JScrollPane consoleScrollPane = new JScrollPane(console);
		consoleScrollPane.setBorder(BorderFactory.createTitledBorder("Console"));
		consoleSplitPane.add(consoleScrollPane);

		dashboard.setBorder(BorderFactory.createTitledBorder("Status"));

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(consoleSplitPane, BorderLayout.CENTER);
		this.getContentPane().add(dashboard, BorderLayout.SOUTH);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int) (screenSize.getWidth() * .75), (int) (screenSize.getHeight() * .75));

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		console.setEditable(false);

		menuBar.add(createFileMenu());
		menuBar.add(createSourceCodeMenu());
		this.setJMenuBar(menuBar);
		// codeShapesSplitPane.setDividerLocation(.5);
		codeShapesSplitPane.setResizeWeight(.5);
		consoleSplitPane.setResizeWeight(.80);
	}

	private JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		fileMenu.add(quitItem);
		return fileMenu;
	}

	private class RunActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				interpreter.interpret(getInputCode(), ambient);
			} catch (CodeException e1) {
				clearConsole();
				error(e1.getMessage());
			}
			shapesPanel.repaint();
			dashboard.repaint();
		}
	}

	private JMenu createSourceCodeMenu() {
		JMenu menu = new JMenu("Source Code");
		JMenuItem runItem = new JMenuItem("Run");
		runItem.addActionListener(new RunActionListener());
		menu.add(runItem);
		return menu;
	}

	public void clearConsole() {
		console.setText("");
	}

	public void error(String message) {
		console.setText(console.getText() + "\n" + message);
	}

	protected String getInputCode() {
		return code.getText();
	}
}
