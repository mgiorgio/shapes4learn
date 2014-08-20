package edu.maimonides.multimedia.shapes4learn.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.layout.FormLayout;

import edu.maimonides.multimedia.shapes4learn.model.ShapeAmbient;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Circle;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Rectangle;
import edu.maimonides.multimedia.shapes4learn.model.shapes.Shape;

public class ShapesDashboard extends JPanel {

	private static final long serialVersionUID = 2189138052628261761L;

	private JLabel circles;

	private JLabel rectangles;

	private ShapeAmbient ambient;

	public ShapesDashboard(ShapeAmbient ambient) {
		this.ambient = ambient;
		initGUI();
	}

	private void initGUI() {
		circles = new JLabel("0");
		rectangles = new JLabel("0");
		FormLayout layout = new FormLayout("right:max(40dlu;pref), 3dlu, 80dlu", ""); // add
																						// rows
																						// dynamically
		DefaultFormBuilder builder = new DefaultFormBuilder(layout).border(Borders.DIALOG);

		builder.append("Rectangles:", rectangles);
		builder.nextLine();
		builder.append("Circles:", circles);

		this.add(builder.build());
	}

	@Override
	public void repaint() {
		super.repaint();

		if (this.ambient != null) {
			this.clearNumbers();

			for (Shape shape : ambient.shapes()) {
				if (shape.isClass(Rectangle.class)) {
					this.increaseRectangle();
				} else if (shape.isClass(Circle.class)) {
					this.increaseCircle();
				}
			}
		}
	}

	private void clearNumbers() {
		this.setRectangles(0);
		this.setCircles(0);
	}

	public void increaseCircle() {
		setCircles(getCircles() + 1);
	}

	public void increaseRectangle() {
		setRectangles(getRectangles() + 1);
	}

	public void setCircles(int number) {
		circles.setText(Integer.toString(number));
	}

	public void setRectangles(int number) {
		rectangles.setText(Integer.toString(number));
	}

	public int getCircles() {
		return Integer.parseInt(circles.getText());
	}

	public int getRectangles() {
		return Integer.parseInt(rectangles.getText());
	}
}