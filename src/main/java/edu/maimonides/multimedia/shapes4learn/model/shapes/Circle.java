package edu.maimonides.multimedia.shapes4learn.model.shapes;

public class Circle extends Shape {

	private int radius;

	public static final int DEFAULT_RADIUS = 10;

	public Circle() {
		this.setRadius(DEFAULT_RADIUS);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int ratio) {
		this.radius = ratio;
	}
}