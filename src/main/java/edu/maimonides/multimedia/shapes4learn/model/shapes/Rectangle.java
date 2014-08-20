package edu.maimonides.multimedia.shapes4learn.model.shapes;

import java.awt.Graphics2D;

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

	public void drawIn(Graphics2D g2d) {
		g2d.setColor(this.getColor().toAWTColor());
		g2d.fillRect(0, 0, this.getBase(), this.getHeight());
	}
}