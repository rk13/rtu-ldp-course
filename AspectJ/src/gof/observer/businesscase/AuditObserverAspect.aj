package gof.observer.businesscase;

import org.aspectj.lang.annotation.Pointcut;
import gof.ObserverAspect;

public aspect AuditObserverAspect extends ObserverAspect {

	declare parents: BusinessObject implements SubjectRole;
	declare parents: AuditFacility  implements ObserverRole;

	@Pointcut("target(BusinessObject) && set (* *)")
	protected void monitor() {}

	public void AuditFacility.update(SubjectRole o, Object arg) {
		((AuditFacility) this).log(arg + "");
	}

	after(SubjectRole s)returning: initialization(BusinessObject.new(..)) && target(s) {
		s.attach(new AuditFacility());
	}
}
