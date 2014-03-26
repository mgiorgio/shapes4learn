package edu.maimonides.multimedia.shapes4learn.model.shapes;

import edu.maimonides.multimedia.shapes4learn.model.Color;

public class Shape {

	private String id;

	private Color color;

	public Shape() {
		color = defaultColor();
	}

	public static Color defaultColor() {
		Color color = new Color();
		color.setBlue(0);
		color.setRed(0);
		color.setGreen(0);
		return color;
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
}