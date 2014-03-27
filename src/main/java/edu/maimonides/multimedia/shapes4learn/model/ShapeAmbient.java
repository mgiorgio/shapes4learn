package edu.maimonides.multimedia.shapes4learn.model;

import edu.maimonides.multimedia.shapes4learn.model.exceptions.InexistentShapeException;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Shape;

/**
 * The environment where the {@link Shape}s live. Once a {@link Shape} is
 * created, it can be added to the {@link ShapeAmbient} and will be there until
 * it is removed. Once in the {@link ShapeAmbient}, it can be retrieved for
 * manipulation.
 * 
 * @author Matias Giorgio
 * 
 */
public interface ShapeAmbient {

	/**
	 * Adds a {@link Shape} to the {@link ShapeAmbient}. If the ambient already
	 * contains a {@link Shape} with the same id of the given shape, the new one
	 * will not be added.
	 * 
	 * @param shape
	 *            The {@link Shape} to be added.
	 */
	public void add(Shape shape);

	/**
	 * Retrieves a {@link Shape} from the {@link ShapeAmbient}.
	 * 
	 * @param id
	 *            The unique id of the {@link Shape} to retrieve.
	 * @return The {@link Shape} with the given unique id.
	 */
	public Shape get(String id) throws InexistentShapeException;

	/**
	 * Removes the {@link Shape} identified by the given id.
	 * 
	 * @param id
	 *            The id of the {@link Shape} to remove.
	 * @throws InexistentShapeException
	 *             If there is no {@link Shape} for the given id.
	 */
	public void remove(String id) throws InexistentShapeException;

	/**
	 * Checks if there is a {@link Shape} for the given id.
	 * 
	 * @param id
	 *            The id to check if there is a {@link Shape} associated to.
	 * @return <code>true</code> if exists a {@link Shape} for the given id.
	 *         Otherwise, <code>false</code>.
	 */
	public boolean contains(String id);

	/**
	 * Retrieves all of the {@link Shape}s present in this {@link ShapeAmbient}.
	 * Future changes on the {@link ShapeAmbient} will not affect the retrieved
	 * {@link Shape}s.
	 * 
	 * @return An {@link Iterable} to obtain the {@link Shape}s.
	 */
	public Iterable<Shape> shapes();
}