package com.pronto.entities.form;

import javax.persistence.Entity;
import javax.persistence.Lob;

import com.pronto.entities.core.LogObject;
import com.pronto.entities.message.Message;

@Entity
public class SignupForm extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7949850173567452388L;

	private String name;
	@Lob
	private String template;
	private PageType thankYouPageType;
	private String thankYouPageURL;
	private PageType alreadySubscribedPageType;
	private String subscribedPageURL;
	private String adTracking;
	private Message startOnMessage;
	private Boolean passFormData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public PageType getThankYouPageType() {
		return thankYouPageType;
	}

	public void setThankYouPageType(PageType thankYouPageType) {
		this.thankYouPageType = thankYouPageType;
	}

	public String getThankYouPageURL() {
		return thankYouPageURL;
	}

	public void setThankYouPageURL(String thankYouPageURL) {
		this.thankYouPageURL = thankYouPageURL;
	}

	public PageType getAlreadySubscribedPageType() {
		return alreadySubscribedPageType;
	}

	public void setAlreadySubscribedPageType(PageType alreadySubscribedPageType) {
		this.alreadySubscribedPageType = alreadySubscribedPageType;
	}

	public String getSubscribedPageURL() {
		return subscribedPageURL;
	}

	public void setSubscribedPageURL(String subscribedPageURL) {
		this.subscribedPageURL = subscribedPageURL;
	}

	public String getAdTracking() {
		return adTracking;
	}

	public void setAdTracking(String adTracking) {
		this.adTracking = adTracking;
	}

	public Message getStartOnMessage() {
		return startOnMessage;
	}

	public void setStartOnMessage(Message startOnMessage) {
		this.startOnMessage = startOnMessage;
	}

	public Boolean getPassFormData() {
		return passFormData;
	}

	public void setPassFormData(Boolean passFormData) {
		this.passFormData = passFormData;
	}

}
