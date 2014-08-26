package edu.maimonides.multimedia.shapes4learn.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Shape;

public class ShapesPanel extends JPanel {

	private static final long serialVersionUID = -5256297764714180092L;

	private ShapeAmbient ambient;

	public ShapesPanel() {
	}

	public ShapeAmbient getAmbient() {
		return ambient;
	}

	public void setAmbient(ShapeAmbient ambient) {
		this.ambient = ambient;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		redraw((Graphics2D) g);
	}

	public void redraw(Graphics2D g2d) {
		for (Shape shape : ambient.shapes()) {
			shape.drawIn(g2d);
		}
	}
}