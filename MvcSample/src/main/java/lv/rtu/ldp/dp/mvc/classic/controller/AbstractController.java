package lv.rtu.ldp.dp.mvc.classic.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import lv.rtu.ldp.dp.mvc.classic.view.View;
import lv.rtu.ldp.dp.mvc.model.AbstractModel;

public abstract class AbstractController implements PropertyChangeListener {

	private ArrayList<View> registeredViews = null;

	private ArrayList<AbstractModel> registeredModels = null;

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		for (View view : registeredViews) {
			view.modelChange(evt);
		}
	}

	public AbstractController() {
		registeredModels = new ArrayList<AbstractModel>();
		registeredViews = new ArrayList<View>();
	}

	public void addModel(AbstractModel model) {
		registeredModels.add(model);
		model.addPropertyChangeListener(this);
	}

	public void removeModel(AbstractModel model) {
		registeredModels.remove(model);
		model.removePropertyChangeListener(this);
	}

	public void addView(View view) {
		registeredViews.add(view);
	}

	public void removeView(View view) {
		registeredModels.remove(view);
	}

	protected void setModelProperty(String propertyName, Object propertyValue) {
		for (AbstractModel model : registeredModels) {

			try {
				Method method = model.getClass().getMethod("set" + propertyName,
						new Class[] { propertyValue.getClass() });
				method.invoke(model, propertyValue);
			} catch (SecurityException e) {
			} catch (NoSuchMethodException e) {
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}

		}
	}

}
