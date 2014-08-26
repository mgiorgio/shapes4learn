package edu.maimonides.multimedia.shapes4learn.model;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class Color {

	/**
	 * Red.
	 */
	private int r;

	/**
	 * Green.
	 */
	private int g;

	/**
	 * Blue.
	 */
	private int b;

	public Color() {
	}

	public void setRed(int red) {
		this.r = red;
	}

	public int getRed() {
		return this.r;
	}

	public void setGreen(int green) {
		this.g = green;
	}

	public int getGreen() {
		return this.g;
	}

	public void setBlue(int blue) {
		this.b = blue;
	}

	public int getBlue() {
		return this.b;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();

		builder.append(r);
		builder.append(g);
		builder.append(b);

		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Color)) {
			return false;
		}
		Color anotherColor = (Color) obj;
		return this.r == anotherColor.r && this.g == anotherColor.g && this.b == anotherColor.b;
	}

	@Override
	public String toString() {
		return String.format("%x%x%x", r, g, b);
	}

	public java.awt.Color toAWTColor() {
		return new java.awt.Color(r, g, b);
	}
}