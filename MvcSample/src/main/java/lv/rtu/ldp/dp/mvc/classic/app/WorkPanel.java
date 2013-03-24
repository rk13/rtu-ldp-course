package lv.rtu.ldp.dp.mvc.classic.app;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import lv.rtu.ldp.dp.mvc.classic.controller.DefaultController;
import lv.rtu.ldp.dp.mvc.classic.view.LoginStatusView;
import lv.rtu.ldp.dp.mvc.classic.view.LoginView;

@SuppressWarnings("serial")
public class WorkPanel extends JPanel {

	private JPanel loginPanel = null;
	private JPanel loginStatusPanel = null;

	public WorkPanel(DefaultController controller) {

		loginPanel = new LoginView(controller);
		loginStatusPanel = new LoginStatusView(controller);
		setLayout(new BorderLayout());
		add(loginPanel, BorderLayout.NORTH);
		add(loginStatusPanel, BorderLayout.SOUTH);
	}

}
