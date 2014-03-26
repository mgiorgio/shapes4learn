package edu.maimonides.multimedia.shapes4learn.model;

import edu.maimonides.multimedia.shapes4learn.model.exceptions.InexistentShapeException;

/**
 * The environment where the {@link Shape}s live. Once a {@link Shape} is
 * created, it can be added to the {@link ModelAmbient} and will be there until
 * it is removed. Once in the {@link ModelAmbient}, it can be retrieved for
 * manipulation.
 * 
 * @author Matias Giorgio
 * 
 */
public interface ModelAmbient {

	/**
	 * Adds a {@link Shape} to the {@link ModelAmbient}. If the ambient already
	 * contains a {@link Shape} with the same id of the given shape, the new one
	 * will not be added.
	 * 
	 * @param shape
	 *            The {@link Shape} to be added.
	 */
	public void add(Shape shape);

	/**
	 * Retrieves a {@link Shape} from the {@link ModelAmbient}.
	 * 
	 * @param id
	 *            The unique id of the {@link Shape} to retrieve.
	 * @return The {@link Shape} with the given unique id.
	 */
	public Shape get(String id) throws InexistentShapeException;

	public void remove(String id) throws InexistentShapeException;

	public boolean contains(String id);
}