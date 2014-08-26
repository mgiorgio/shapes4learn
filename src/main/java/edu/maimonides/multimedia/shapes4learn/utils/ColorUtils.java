package edu.maimonides.multimedia.shapes4learn.utils;

import edu.maimonides.multimedia.shapes4learn.model.Color;

public class ColorUtils {

	private ColorUtils() {
	}

	/**
	 * Creates a {@link Color} instance based on a #rrggbb pattern.
	 * 
	 * @param string
	 *            The pattern.
	 * @return The {@link Color} instance.
	 */
	public static Color color(String string) {
		Color color = new Color();
		color.setRed(Integer.parseInt(string.substring(0, 2), 16));
		color.setGreen(Integer.parseInt(string.substring(2, 4), 16));
		color.setBlue(Integer.parseInt(string.substring(4, 6), 16));
		return color;
	}

}
