package edu.maimonides.multimedia.shapes4learn.model.shapes;

import java.awt.Graphics2D;

import edu.maimonides.multimedia.shapes4learn.model.Color;

/**
 * The basic object that can be created, deleted and manipulated in Shape4Learn.
 * 
 * @author Matias Giorgio.
 * 
 */
public class Shape {

	private String id;

	private Color color;

	private int x;

	private int y;

	public Shape() {
		color = defaultColor();
	}

	/**
	 * @return The default {@link Color} assigned to new objects.
	 */
	public static Color defaultColor() {
		Color color = new Color();
		color.setBlue(0);
		color.setRed(0);
		color.setGreen(0);
		return color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isClass(Class<? extends Shape> clazz) {
		return clazz.isAssignableFrom(this.getClass());
	}

	public void drawIn(Graphics2D g2d) {
		// Do nothing. Shape will become abstract then this method will be
		// abstract too.
	}
}