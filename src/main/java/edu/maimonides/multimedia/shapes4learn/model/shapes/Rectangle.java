package edu.maimonides.multimedia.shapes4learn.model.shapes;

public class Rectangle extends Shape {

	private int base;

	private int height;

	public static final int DEFAULT_BASE = 10;

	public static final int DEFAULT_HEIGHT = 10;

	public Rectangle() {
		this.setBase(DEFAULT_BASE);
		this.setHeight(DEFAULT_HEIGHT);
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}