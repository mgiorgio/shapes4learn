package edu.maimonides.multimedia.shapes4learn.model.shapes;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

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

	@Override
	public void drawIn(Graphics2D g2d) {
		g2d.setColor(this.getColor().toAWTColor());
		g2d.fill(new Ellipse2D.Double(this.getX(), this.getY(), this.radius * 2, this.radius * 2));
	}
}
