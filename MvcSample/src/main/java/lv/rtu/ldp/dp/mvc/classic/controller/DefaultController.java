package lv.rtu.ldp.dp.mvc.classic.controller;

import lv.rtu.ldp.dp.mvc.model.LoginModel;

public class DefaultController extends AbstractController {

	public void doLogout() {
		//...
		setModelProperty(LoginModel.MODEL_PROP_LOGIN_STATUS, false);
	}

	public void doLogin(String login, String pwd) {
		//...
		setModelProperty(LoginModel.MODEL_PROP_LOGIN_STATUS, true);
	}
}
