package lv.rtu.ldp.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "lv.rtu.ldp.ws.LdpWs")
public class LdpWsImpl implements LdpWs {
	@Override
	public String getStringVal() {
		return "Test";
	}
}
