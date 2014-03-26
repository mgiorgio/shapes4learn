package edu.maimonides.multimedia.shapes4learn.interpreter;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import edu.maimonides.multimedia.shapes4learn.model.shapes.Rectangle;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Shape;
import edu.maimonides.multimedia.shapes4learn.utils.ColorUtils;
import edu.maimonides.multimedia.shapes4learn.utils.ShapeUtils;

/**
 * Hard-coded, regex-based implementation of {@link Interpreter}, mostly for
 * testing purposes.
 * 
 * @author Matias Giorgio.
 * 
 */
public class RegexInterpreter extends Interpreter {

	private static final String NUMBER_PATTERN = "\\d+";
	private static final String SHAPE_TYPE_PATTERN = "[a-zA-Z]+";
	private static final String CREATE_KEYWORD = "create";
	private static final String SET_COLOR_KEYWORD = "setcolor";
	private static final String SET_BASE_KEYWORD = "setbase";

	private static final String ID_PATTERN = SHAPE_TYPE_PATTERN;

	private Pattern createPattern;
	private Pattern setColorPattern;
	private Pattern setbasePatternInRectangle;

	public RegexInterpreter() {
		createPattern = Pattern.compile(CREATE_KEYWORD + " (" + SHAPE_TYPE_PATTERN + ") (" + ID_PATTERN + ");", Pattern.CASE_INSENSITIVE);
		setColorPattern = Pattern.compile(SET_COLOR_KEYWORD + " \\#([0-9a-fA-F]{6,6}) in shape (" + ID_PATTERN + ");", Pattern.CASE_INSENSITIVE);
		setbasePatternInRectangle = Pattern.compile(SET_BASE_KEYWORD + " (" + NUMBER_PATTERN + ") in rectangle (" + ID_PATTERN + ");");
	}

	@Override
	public void interpret(String code) throws CodeException {
		code = code.trim();

		if (code.startsWith(CREATE_KEYWORD)) {
			processCreateShape(code);
		} else if (code.startsWith(SET_COLOR_KEYWORD)) {
			processSetColor(code);
		} else if (code.startsWith(SET_BASE_KEYWORD)) {
			processSetBase(code);
		} else {
			throw new CodeException("Unexpected code.");
		}
	}

	private void processSetBase(String code) throws CodeException {
		Matcher matcher = setbasePatternInRectangle.matcher(code);

		if (matcher.find()) {
			int base = Integer.parseInt(matcher.group(1));
			String id = matcher.group(2);

			if (this.getShapeAmbient().contains(id)) {
				Rectangle rectangle = (Rectangle) this.getShapeAmbient().get(id);
				rectangle.setBase(base);
			} else {
				throw new CodeException("Id " + id + " does not exist.");
			}
		} else {
			throw new CodeException("Unexpected code");
		}
	}

	private void processSetColor(String code) throws CodeException {
		Matcher matcher = setColorPattern.matcher(code);

		if (matcher.find()) {
			String colorDef = matcher.group(1);
			String id = matcher.group(2);

			if (this.getShapeAmbient().contains(id)) {
				Shape shape = this.getShapeAmbient().get(id);
				shape.setColor(ColorUtils.color(colorDef));
			} else {
				throw new CodeException("Unrecognized identifier");
			}
		} else {
			throw new CodeException("Unexpected code");
		}
	}

	private void processCreateShape(String code) throws CodeException {
		Matcher matcher = createPattern.matcher(code);

		if (matcher.find()) {
			String type = matcher.group(1);
			String id = matcher.group(2);

			Shape shape = createShape(type, id);
			if (this.getShapeAmbient().contains(id)) {
				throw new CodeException("Id " + id + " already exists.");
			} else {
				this.getShapeAmbient().add(shape);
			}
		} else {
			throw new CodeException("Unrecognized identifier");
		}
	}

	private Shape createShape(String type, String id) throws CodeException {
		switch (type) {
		case "shape":
			return ShapeUtils.shape(id);
		case "rectangle":
			return ShapeUtils.rectangle(id);
		case "circle":
			return ShapeUtils.circle(id);
		default:
			throw new CodeException("Shape type does not exist");
		}
	}

	@Override
	public void interpret(InputStream stream) throws CodeException, IOException {
		this.interpret(IOUtils.toString(stream));
	}

}