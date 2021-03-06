package gof;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.aspectj.lang.Signature;

public abstract aspect ObserverAspect
{
	public interface SubjectRole {
		void notifyObservers(Object arg);
		void attach(ObserverRole o);
		void detach(ObserverRole o);
	}

	public interface ObserverRole {
		void update(SubjectRole s, Object arg);
	}

	private List<ObserverRole> SubjectRole.list = new CopyOnWriteArrayList<ObserverRole>();

	public void SubjectRole.attach(ObserverRole o) {
		list.add(o);
	}

	public void SubjectRole.detach(ObserverRole o) {
		list.remove(o);
	}

	public void SubjectRole.notifyObservers(Object a) {
		for (ObserverRole o : list) {
			o.update(this, a);
		}
	}

	protected abstract pointcut monitor();

	after(SubjectRole s): monitor() && target(s)
	{
		s.notifyObservers(getFieldName(thisJoinPointStaticPart.getSignature()));
	}
	
	private Object getFieldName(Signature sig) {
		try {return sig.getDeclaringType().getDeclaredField(sig.getName()).getName();} catch (Throwable t) {}
		return null;
	}
}
