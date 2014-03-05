package lv.rtu.ldp.dp.mvc.classic.app;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lv.rtu.ldp.dp.mvc.classic.controller.DefaultController;
import lv.rtu.ldp.dp.mvc.model.UserModel;

@SuppressWarnings("serial")
public class App extends JFrame {

	private DefaultController controller = null;
	private UserModel model = null;

	public App() {
		controller = new DefaultController();
		model = new UserModel();

		controller.addModel(model);

		JPanel center = new WorkPanel(controller);
		setTitle("MVC Pattern Application");
		add(center);
		pack();
	}

	public static void main(String... args) {
		App app = new App();
		app.setVisible(true);
	}

}
