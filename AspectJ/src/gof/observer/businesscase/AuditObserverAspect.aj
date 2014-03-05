package gof.observer.businesscase;

import gof.ObserverAspect;

public aspect AuditObserverAspect extends ObserverAspect
{
	declare parents: BusinessObject implements SubjectRole;
	declare parents: AuditFacility  implements ObserverRole;

	protected pointcut monitor() :
		set (* *) && target(BusinessObject);

	public void AuditFacility.update(SubjectRole o, Object arg) {
		((AuditFacility) this).log(arg + "");
	}

	after(SubjectRole s) returning: initialization(BusinessObject.new(..)) && target(s) {
		s.attach((ObserverRole) new AuditFacility());
	}
}
