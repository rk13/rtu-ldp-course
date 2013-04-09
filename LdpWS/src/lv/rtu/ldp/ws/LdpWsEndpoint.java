package lv.rtu.ldp.ws;

import javax.xml.ws.Endpoint;

public class LdpWsEndpoint {
	
	public static void main(String[] args) 
	{
		Endpoint.publish("http://127.0.0.1:12345/ldp", new LdpWsImpl());
	}

}
