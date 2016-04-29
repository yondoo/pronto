/* 
 * Package Name: com.pronto.entities.core
 * File Name: BaseObject.java
 * 
 * Created By: J.Tuguldur 
 * Created Date: 2016/01/07
 * 
 * History 
 * ------------------------------------------------------------------------------
 * Date							Programmer						Description
 * ------------------------------------------------------------------------------
 * 2016/01/07 1.0.0 			J.Tuguldur   					Шинээр үүсгэв.
 * ------------------------------------------------------------------------------
 * 
 */

package com.pronto.entities.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tapestry5.beaneditor.NonVisual;

import com.pronto.util.Util;

@MappedSuperclass
public abstract class LogObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9121418874648889713L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@NonVisual
	private Long id;

	@Column(length = 32, insertable = true, updatable = false)
	@NonVisual
	private String uuid;

	@Column(updatable = false)
	@NonVisual
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@NonVisual
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@NonVisual
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public LogObject() {
		uuid = Util.getUUID();
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null)
			return false;

		if (!(o instanceof LogObject)) {
			return false;
		}

		final LogObject e = (LogObject) o;

		if (e.getId() == null)
			return false;

		if (this.getId() == null)
			return false;
		return getId().equals(e.getId());
	}

	public int hashCode() {
		return getUuid().hashCode();
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
