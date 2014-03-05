package lv.rtu.ldp.dp.mvc.model;

import lv.rtu.ldp.dp.mvc.util.Constants;

public class LoginModel extends AbstractModel implements Constants {

	private boolean loginStatus = false;

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Boolean newLoginStatus) {
		Boolean oldLoginStatus = loginStatus;
		loginStatus = newLoginStatus;
		modelChange(MODEL_PROP_LOGIN_STATUS, oldLoginStatus, newLoginStatus);
	}
}
