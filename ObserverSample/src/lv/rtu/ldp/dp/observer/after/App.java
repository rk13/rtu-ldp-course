package lv.rtu.ldp.dp.observer.after;

public class App {

	Sensor s = new Sensor();
	Tomato t = new Tomato();

	public void start() {
		t.addObserver(s);
		t.ready();
	}

	public static void main(String[] args) {
		new App().start();
	}

}