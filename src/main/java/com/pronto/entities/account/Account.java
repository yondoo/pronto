package com.pronto.entities.account;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.util.ByteSource;
import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

import com.pronto.entities.core.LogObject;
import com.pronto.util.Constants;
import com.pronto.util.Util;

@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 805034856783166205L;

	/* AccountEdit information */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@NonVisual
	private Long id;

	@Column(length = 32, insertable = true, updatable = false)
	@NonVisual
	private String uuid;
	@Validate(value = "required, maxlength=20, regexp=^[A-Za-z0-9]+$")
	private String username;
	@Validate(value = "required, maxlength=20")
	private String password;
	private byte[] passwordSalt;
	private String firstName;
	private String lastName;
	@Validate(value = "maxlength=10, regexp=^[A-Za-zА-Яа-я0-9]+$")
	private String email;
	private String phoneNumber;
	private String website;
	private String companyName;

	/* Billing information */
	@Validate(value = "maxlength=50, regexp=^[A-Za-z0-9]+$")
	private String billAddress1;
	@Validate(value = "maxlength=50, regexp=^[A-Za-z0-9]+$")
	private String billAddress2;
	private String city;
	private String country;
	private Integer creditCardNumber;
	private Integer cvv;
	private Date expirationDate;

	/* Authentication */
	@NonVisual
	@Column(length = 128)
	public byte[] getPasswordSalt() {
		return passwordSalt;
	}

	public String generateRandomPassword() {
		String password = Util.generateRandom(Constants.PASSWORD_RANDOM_LENGTH_MIN,
				Constants.PASSWORD_RANDOM_LENGTH_MAX);
		return password;
	}

	/* Getter & Setter */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password != null && !password.equals(this.password) && !"".equals(password)) {
			ByteSource saltSource = new SecureRandomNumberGenerator().nextBytes();
			this.passwordSalt = saltSource.getBytes();
			this.password = new Sha1Hash(password, saltSource).toString();
		}
	}

	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBillAddress1() {
		return billAddress1;
	}

	public void setBillAddress1(String billAddress1) {
		this.billAddress1 = billAddress1;
	}

	public String getBillAddress2() {
		return billAddress2;
	}

	public void setBillAddress2(String billAddress2) {
		this.billAddress2 = billAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Integer creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Account() {
		uuid = Util.getUUID();
	}

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

	/* Object identifier */
	@Override
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

	@Override
	public int hashCode() {
		return getUuid().hashCode();
	}
}
