package com.pronto.entities.list;

import javax.persistence.Entity;

import com.pronto.entities.core.LogObject;

@Entity
public class List extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6749483720287479206L;

	private String name;
	private String listID;
	private String description;
	private String fromName;
	private String fromEmailAddress;
	private String contactAddress1;
	private String contactAddress2;
	private String contactCity;
	private String contactState;
	private String contactPostalCode;
	private String contactCountry;
	private String companyName;
	private String websiteURL;
	private String emailSignature;
	private String logoName;
	private String confirmSubject;
	private String confirmMessageBody;
	private String confirmSuccessPageURL;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListID() {
		return listID;
	}

	public void setListID(String listID) {
		this.listID = listID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getFromEmailAddress() {
		return fromEmailAddress;
	}

	public void setFromEmailAddress(String fromEmailAddress) {
		this.fromEmailAddress = fromEmailAddress;
	}

	public String getContactAddress1() {
		return contactAddress1;
	}

	public void setContactAddress1(String contactAddress1) {
		this.contactAddress1 = contactAddress1;
	}

	public String getContactAddress2() {
		return contactAddress2;
	}

	public void setContactAddress2(String contactAddress2) {
		this.contactAddress2 = contactAddress2;
	}

	public String getContactCity() {
		return contactCity;
	}

	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}

	public String getContactState() {
		return contactState;
	}

	public void setContactState(String contactState) {
		this.contactState = contactState;
	}

	public String getContactPostalCode() {
		return contactPostalCode;
	}

	public void setContactPostalCode(String contactPostalCode) {
		this.contactPostalCode = contactPostalCode;
	}

	public String getContactCountry() {
		return contactCountry;
	}

	public void setContactCountry(String contactCountry) {
		this.contactCountry = contactCountry;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsiteURL() {
		return websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}

	public String getEmailSignature() {
		return emailSignature;
	}

	public void setEmailSignature(String emailSignature) {
		this.emailSignature = emailSignature;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public String getConfirmSubject() {
		return confirmSubject;
	}

	public void setConfirmSubject(String confirmSubject) {
		this.confirmSubject = confirmSubject;
	}

	public String getConfirmMessageBody() {
		return confirmMessageBody;
	}

	public void setConfirmMessageBody(String confirmMessageBody) {
		this.confirmMessageBody = confirmMessageBody;
	}

	public String getConfirmSuccessPageURL() {
		return confirmSuccessPageURL;
	}

	public void setConfirmSuccessPageURL(String confirmSuccessPageURL) {
		this.confirmSuccessPageURL = confirmSuccessPageURL;
	}

}
