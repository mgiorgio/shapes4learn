package edu.maimonides.multimedia.shapes4learn.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Circle;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Rectangle;
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
			if (shape.isClass(Rectangle.class)) {
				drawRectangle(g2d, (Rectangle) shape);
			} else if (shape.isClass(Circle.class)) {
				drawCircle(g2d, (Circle) shape);
			} else {
				System.err.println("Unknown figure.");
			}
		}
	}

	private void drawCircle(Graphics2D g2d, Circle shape) {
		// TODO Auto-generated method stub

	}

	private void drawRectangle(Graphics2D g2d, Rectangle shape) {
		g2d.setColor(shape.getColor().toAWTColor());
		g2d.fillRect(0, 0, shape.getBase(), shape.getHeight());
	}

}