package lv.rtu.ldp.dp.observer.before;

import java.awt.Color;

public class Tomato {

	private Color color = Color.GREEN;

	public Color getColor() {
		return color;
	}

	public void setColor(Color acolor) {
		color = acolor;
		// --
		if (Color.RED == color) {
			App.app.s.react(this);
		}
		// --
	}

	public void ready() {
		setColor(Color.RED);
	}
}
