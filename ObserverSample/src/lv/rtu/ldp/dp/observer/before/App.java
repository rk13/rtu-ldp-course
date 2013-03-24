package lv.rtu.ldp.dp.observer.before;

public class App {

	static App app = new App();

	Sensor s = new Sensor();
	Tomato t = new Tomato();

	public static void main(String[] args) {
		app.t.ready();
	}

}
