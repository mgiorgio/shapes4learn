package edu.maimonides.multimedia.shapes4learn.model;

public class Shape {
	
	private String id;

	private Color color;

	public Shape() {
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
}