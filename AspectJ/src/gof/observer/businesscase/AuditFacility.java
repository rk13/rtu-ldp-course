package gof.observer.businesscase;

public class AuditFacility {

	public void log(String auditMessage) 
	{
		System.out.println("*** AUDIT: CHANGES IN [" + auditMessage + "]");
	}

}
