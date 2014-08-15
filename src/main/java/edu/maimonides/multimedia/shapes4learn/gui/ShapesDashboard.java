package edu.maimonides.multimedia.shapes4learn.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.layout.FormLayout;

public class ShapesDashboard extends JPanel {

	private JLabel circles;

	private JLabel rectangles;

	public ShapesDashboard() {
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