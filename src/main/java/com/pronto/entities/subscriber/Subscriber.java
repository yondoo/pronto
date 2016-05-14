package com.pronto.entities.subscriber;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.pronto.entities.core.LogObject;
import com.pronto.entities.list.List;

@Entity
public class Subscriber extends LogObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5895671535479189273L;

	private String name;
	private String email;
	private String adTracking;
	private String tags;
	private String additionalNotes;
	private Integer messageNumber;
	private SubscriberStatus status;
	private StopMethod stopMethod;
	private Boolean isConfirmed;
	private AddMethod addMethod;
	private String addURL;
	private String addIP;
	private String confirmationIP;
	private Date dateLastFollowup;
	private Date dateStopped;
	private Date dateConfirmed;
	private String country;
	private String region;
	private String city;
	private String postalCode;
	private String latitude;
	private String longitude;
	private String areaCode;
	private String DMACode;
	private Boolean isUndeliverable;
	private Integer saleAmount;
	@ManyToOne
	private List list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdTracking() {
		return adTracking;
	}

	public void setAdTracking(String adTracking) {
		this.adTracking = adTracking;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public Integer getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(Integer messageNumber) {
		this.messageNumber = messageNumber;
	}

	public SubscriberStatus getStatus() {
		return status;
	}

	public void setStatus(SubscriberStatus status) {
		this.status = status;
	}

	public StopMethod getStopMethod() {
		return stopMethod;
	}

	public void setStopMethod(StopMethod stopMethod) {
		this.stopMethod = stopMethod;
	}

	public Boolean getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public AddMethod getAddMethod() {
		return addMethod;
	}

	public void setAddMethod(AddMethod addMethod) {
		this.addMethod = addMethod;
	}

	public String getAddURL() {
		return addURL;
	}

	public void setAddURL(String addURL) {
		this.addURL = addURL;
	}

	public String getAddIP() {
		return addIP;
	}

	public void setAddIP(String addIP) {
		this.addIP = addIP;
	}

	public String getConfirmationIP() {
		return confirmationIP;
	}

	public void setConfirmationIP(String confirmationIP) {
		this.confirmationIP = confirmationIP;
	}

	public Date getDateLastFollowup() {
		return dateLastFollowup;
	}

	public void setDateLastFollowup(Date dateLastFollowup) {
		this.dateLastFollowup = dateLastFollowup;
	}

	public Date getDateStopped() {
		return dateStopped;
	}

	public void setDateStopped(Date dateStopped) {
		this.dateStopped = dateStopped;
	}

	public Date getDateConfirmed() {
		return dateConfirmed;
	}

	public void setDateConfirmed(Date dateConfirmed) {
		this.dateConfirmed = dateConfirmed;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDMACode() {
		return DMACode;
	}

	public void setDMACode(String dMACode) {
		DMACode = dMACode;
	}

	public Boolean getIsUndeliverable() {
		return isUndeliverable;
	}

	public void setIsUndeliverable(Boolean isUndeliverable) {
		this.isUndeliverable = isUndeliverable;
	}

	public Integer getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Integer saleAmount) {
		this.saleAmount = saleAmount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
