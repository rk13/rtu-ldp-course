package lv.rtu.ldp.dp.mvc.classic.view;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lv.rtu.ldp.dp.mvc.classic.controller.DefaultController;

@SuppressWarnings("serial")
public class LoginStatusView extends JPanel implements View {

	private JLabel loginStatus = new JLabel();

	public LoginStatusView(DefaultController controller) {
		setLayout(new GridLayout(1, 2));
		add(new JLabel("Login status:"));
		add(loginStatus);
		controller.addView(this);
	}

	@Override
	public void modelChange(PropertyChangeEvent evt) {
		if ("LoginStatus".equals(evt.getPropertyName())) {
			loginStatus.setText(evt.getNewValue() + "");
		}

	}

}
