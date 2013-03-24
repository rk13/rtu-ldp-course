package lv.rtu.ldp.dp.observer.after;

import java.awt.Color;
import java.util.Observable;

public class Tomato extends Observable {

	private Color color = Color.GREEN;

	public Color getColor() {
		return color;
	}

	public void setColor(Color acolor) {
		color = acolor;
		// --
		setChanged();
		notifyObservers(color);
		// --
	}

	public void ready() {
		setColor(Color.RED);
	}
}
