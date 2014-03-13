package lv.rtu.ldp.ws;

import static java.lang.System.out;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class LdpWsClient 
{
	public static void main(String args[]) throws Exception 
	{
		Service service = Service.create(
				new URL("http://localhost:12345/ldp?wsdl"), 
				new QName("http://ws.ldp.rtu.lv/", "LdpWsImplService"));

		LdpWs eif = service.getPort(LdpWs.class);
	
		out.println("Result = " + eif.getStringVal());

	}
}
