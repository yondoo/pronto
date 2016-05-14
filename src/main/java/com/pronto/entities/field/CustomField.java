package com.pronto.entities.field;

import javax.persistence.Entity;

import com.pronto.entities.core.LogObject;

@Entity
public class CustomField extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3560894519841098976L;

	private String name;
	private Boolean subscriberUpdate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSubscriberUpdate() {
		return subscriberUpdate;
	}

	public void setSubscriberUpdate(Boolean subscriberUpdate) {
		this.subscriberUpdate = subscriberUpdate;
	}

}
