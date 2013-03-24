package lv.rtu.ldp.dp.observer.after;

import static java.lang.System.out;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class Sensor implements Observer {

	@Override
	public void update(Observable tomato, Object color) {
		if (Color.red == (Color) color) {
			out.println("Tomato ready!");
		}
	}
}
