package com.d2derp.oep.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UserPojo {

	private int id;
	private int sno;
	private String firstName;
	private String lastName;
	private String email;
	private long mobileNumber;
	private String pass;
	private String cpass;
	private String status;
	private Date createdDate;
	private Date lastModifiedDate;
	private int ipAddress;
	
	
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	private UserTypePojo userTypePojo;
	
	
	private ClientPojo clientPojo;
		
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public int getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(int ipAddress) {
		this.ipAddress = ipAddress;
	}
	public UserTypePojo getUserTypePojo() {
		return userTypePojo;
	}
	public void setUserTypePojo(UserTypePojo userTypePojo) {
		this.userTypePojo = userTypePojo;
	}
	public ClientPojo getClientPojo() {
		return clientPojo;
	}
	public void setClientPojo(ClientPojo clientPojo) {
		this.clientPojo = clientPojo;
	}
	
}
