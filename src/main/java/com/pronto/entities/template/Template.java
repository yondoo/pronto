package com.pronto.entities.template;

import javax.persistence.Entity;
import javax.persistence.Lob;

import com.pronto.entities.core.LogObject;

@Entity
public class Template extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7622411285194324715L;

	private String name;
	@Lob
	private String template;

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

}
