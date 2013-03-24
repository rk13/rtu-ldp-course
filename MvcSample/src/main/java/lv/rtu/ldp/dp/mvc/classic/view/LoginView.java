package lv.rtu.ldp.dp.mvc.classic.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lv.rtu.ldp.dp.mvc.classic.controller.DefaultController;

@SuppressWarnings("serial")
public class LoginView extends JPanel implements View {

	private JButton cmdLogin = new JButton("Login");

	private JButton cmdLogout = new JButton("Logout");

	private DefaultController controller = null;

	private JTextField login = new JTextField(15);

	private JTextField password = new JTextField(15);

	public LoginView(DefaultController a_controller) {
		controller = a_controller;
		controller.addView(this);
		setLayout(new GridLayout(3, 2));
		add(new JLabel("Login:"));
		add(login);
		add(new JLabel("Password:"));
		add(password);
		add(cmdLogin);
		cmdLogout.setVisible(false);
		add(cmdLogout);

		cmdLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.doLogin(login.getText(), password.getText());
			}
		});

		cmdLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.doLogout();
			};
		});
	}

	@Override
	public void modelChange(PropertyChangeEvent evt) {
		if ("LoginStatus".equals(evt.getPropertyName())) {
			if (Boolean.TRUE.equals(evt.getNewValue())) {
				cmdLogout.setVisible(true);
				cmdLogin.setVisible(false);
			} else {
				cmdLogout.setVisible(false);
				cmdLogin.setVisible(true);
			}
		}

	}
}
