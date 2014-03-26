package edu.maimonides.multimedia.shapes4learn.utils;

import edu.maimonides.multimedia.shapes4learn.model.Color;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Circle;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Rectangle;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Shape;

public class ShapeUtils {

	private ShapeUtils() {
	}

	public static Shape shape(String id) {
		Shape shape = new Shape();
		shape.setId(id);
		return shape;
	}

	public static Shape shape(String id, Color color) {
		Shape shape = shape(id);
		shape.setColor(color);
		return shape;
	}

	public static Shape shape(String id, int r, int g, int b) {
		Color c = new Color();
		c.setRed(r);
		c.setGreen(g);
		c.setBlue(b);
		return shape(id, c);
	}

	public static Rectangle rectangle(String id) {
		Rectangle rectangle = new Rectangle();
		rectangle.setId(id);
		return rectangle;
	}

	public static Circle circle(String id) {
		Circle circle = new Circle();
		circle.setId(id);
		return circle;
	}
}