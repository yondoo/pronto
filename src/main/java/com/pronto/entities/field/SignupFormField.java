package com.pronto.entities.field;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.pronto.entities.core.LogObject;
import com.pronto.entities.form.SignupForm;

@Entity
public class SignupFormField extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8660041982309782759L;

	@ManyToOne
	private SignupForm signupForm;
	@ManyToOne
	private CustomField customField;

	public SignupForm getSignupForm() {
		return signupForm;
	}

	public void setSignupForm(SignupForm signupForm) {
		this.signupForm = signupForm;
	}

	public CustomField getCustomField() {
		return customField;
	}

	public void setCustomField(CustomField customField) {
		this.customField = customField;
	}

}
