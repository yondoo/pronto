package com.pronto.entities.message;

import javax.persistence.Entity;
import javax.persistence.Lob;

import com.pronto.entities.core.LogObject;

@Entity
public class Message extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7622411285194324715L;

	private String subject;
	@Lob
	private String template;
	private MessageStatus status;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

}
