package edu.maimonides.multimedia.shapes4learn.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;
import edu.maimonides.multimedia.shapes4learn.model.exceptions.InexistentShapeException;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Shape;

/**
 * A basic implementation of {@link ShapeAmbient}. {@link Shape}s are backed on
 * a {@link HashMap}.
 * 
 * @author Matias Giorgio
 * 
 */
public class BasicShapeAmbient implements ShapeAmbient {

	private Map<String, Shape> shapes;

	public BasicShapeAmbient() {
		shapes = new HashMap<>();
	}

	@Override
	public void add(Shape shape) {
		if (!this.contains(shape.getId())) {
			this.shapes.put(shape.getId(), shape);
		}
	}

	@Override
	public Shape get(String id) throws InexistentShapeException {
		if (this.contains(id)) {
			return this.shapes.get(id);
		} else {
			throw new InexistentShapeException("There is no shape with id " + id);
		}
	}

	@Override
	public void remove(String id) throws InexistentShapeException {
		if (this.contains(id)) {
			this.shapes.remove(id);
		} else {
			throw new InexistentShapeException("There is no shape with id " + id);
		}
	}

	@Override
	public boolean contains(String id) {
		return this.shapes.containsKey(id);
	}

	@Override
	public Iterable<Shape> shapes() {
		return new ArrayList<>(this.shapes.values());
	}
}