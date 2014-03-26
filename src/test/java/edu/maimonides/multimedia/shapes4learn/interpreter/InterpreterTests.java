package edu.maimonides.multimedia.shapes4learn.interpreter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.maimonides.multimedia.shapes4learn.model.Color;
import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;
import edu.maimonides.multimedia.shapes4learn.model.exceptions.InexistentShapeException;
import edu.maimonides.multimedia.shapes4learn.model.impl.BasicShapeAmbient;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Circle;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Rectangle;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Shape;
import edu.maimonides.multimedia.shapes4learn.utils.ColorUtils;

/**
 * Test Suite for all of the available operations of the {@link Interpreter}.
 * Each {@link Interpreter} implementation needs to subclass this class and
 * implement the {@link InterpreterTests#createInterpreter(ShapeAmbient)} in
 * order to create the proper instance.
 * 
 * @author Matias Giorgio
 * 
 */
public abstract class InterpreterTests {

	/**
	 * The {@link Interpreter} under test.
	 */
	private Interpreter interpreter;

	/**
	 * The ambient for the interpreter.
	 */
	private ShapeAmbient ambient;

	/**
	 * Creates the {@link BasicShapeAmbient} and calls
	 * {@link InterpreterTests#createInterpreter(ShapeAmbient)}.
	 */
	@Before
	public void setUp() {
		ambient = new BasicShapeAmbient();
		interpreter = createInterpreter(ambient);
	}

	/**
	 * This method has to be implemented by subclasses.
	 * 
	 * @param ambient
	 *            The {@link ShapeAmbient} to be used with the
	 *            {@link Interpreter}.
	 * @return The {@link Interpreter} instance that will be tested.
	 */
	protected abstract Interpreter createInterpreter(ShapeAmbient ambient);

	/**
	 * Tests the create shape action. After the interpretation, this method will
	 * verify that the created shape has the proper id and default color.
	 * 
	 * @throws InexistentShapeException
	 *             If the shape was not created.
	 * @throws CodeException
	 *             If the code cannot be processed.
	 */
	@Test
	public void testCreateShape() throws CodeException {
		commonShapeAssertions("testshape", "shape", Shape.class);
	}

	private void createShape(final String shapeID) throws CodeException {
		createShape("shape", shapeID);
	}

	private void createShape(String specificShape, final String shapeID) throws CodeException {
		final String code = "create " + specificShape + " " + shapeID + ";";

		interpreter.interpret(code);
	}

	@Test
	public void testSetColor() throws CodeException {
		final String colorDef = "#123456";
		final String SHAPE_ID = "testshape";
		final String code = "setcolor " + colorDef + " in shape " + SHAPE_ID + ";";

		createShape(SHAPE_ID);

		interpreter.interpret(code);

		Shape shape = ambient.get(SHAPE_ID);

		Color color = ColorUtils.color("123456");

		Assert.assertEquals("Retrieved shape has invalid color", color, shape.getColor());
	}

	@Test
	public void testSetColorOnUnknownID() {
		final String colorDef = "#123456";
		final String SHAPE_ID = "testshape";
		final String code = "set color " + colorDef + " in shape " + SHAPE_ID + ";";

		try {
			interpreter.interpret(code);
			Assert.fail("The interpreter should have failed because the ID does not exist.");
		} catch (CodeException e) {
			// Expected.
		}
	}

	@Test
	public void testCreateRectangle() throws CodeException {
		final String SHAPE_ID = "testrectangle";
		Shape shape = commonShapeAssertions(SHAPE_ID, "rectangle", Rectangle.class);

		Rectangle rectangle = (Rectangle) shape;

		Assert.assertEquals("Retrieved rectangle has invalid height", Rectangle.DEFAULT_HEIGHT, rectangle.getHeight());
		Assert.assertEquals("Retrieved rectangle has invalid base", Rectangle.DEFAULT_BASE, rectangle.getBase());
	}

	@Test
	public void testCreateCircle() throws CodeException {
		final String SHAPE_ID = "testcircle";
		Shape shape = commonShapeAssertions(SHAPE_ID, "circle", Circle.class);

		Circle circle = (Circle) shape;

		Assert.assertEquals("Retrieved circle has invalid radius", Circle.DEFAULT_RADIUS, circle.getRadius(), 0.01);
	}

	public Shape commonShapeAssertions(String shapeID, String shapeDef, Class<? extends Shape> shapeClass) throws CodeException, InexistentShapeException {
		final String SHAPE_ID = "testrectangle";

		createShape(shapeDef, SHAPE_ID);

		Shape shape = ambient.get(SHAPE_ID);
		if (!shape.isClass(shapeClass)) {
			throw new CodeException("Create shape is not a " + shapeDef + ".");
		}

		Assert.assertEquals("Retrieved shape has invalid id", SHAPE_ID, shape.getId());
		Assert.assertEquals("Retrieved shape has invalid color", Shape.defaultColor(), shape.getColor());

		return shape;
	}

	@Test
	public void testSetBaseInRectangle() throws CodeException {
		final int base = 20;
		final String SHAPE_ID = "testrectangle";
		final String code = "setbase " + base + " in rectangle " + SHAPE_ID + ";";

		createShape("rectangle", SHAPE_ID);

		interpreter.interpret(code);

		Rectangle rectangle = (Rectangle) ambient.get(SHAPE_ID);

		Assert.assertEquals("Retrieved rectangle has invalid base", base, rectangle.getBase());
	}

	@Test
	public void testThatBaseCannotBeSetInCircles() {
		final int base = 20;
		final String SHAPE_ID = "testrectangle";
		final String code = "setbase " + base + " in circle " + SHAPE_ID + ";";

		try {
			createShape("circle", SHAPE_ID);
		} catch (CodeException e) {
			Assert.fail(e.getMessage());
		}

		try {
			interpreter.interpret(code);
			Assert.fail("Base cannot be set in a circle");
		} catch (CodeException e) {
			// Expected.
		}

		Circle circle = (Circle) ambient.get(SHAPE_ID);
	}
}