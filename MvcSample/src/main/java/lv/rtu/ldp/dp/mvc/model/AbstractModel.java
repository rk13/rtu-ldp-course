package lv.rtu.ldp.dp.mvc.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractModel {

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	protected void modelChange(String propertyName, Object oldValue, Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}
}
