package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_tbl")
public class Customer extends BaseEntity {

	private String Password;
	private String mobile;
	private String pcode;
	private String country;
	private String zip;
	private String state;
	private String address;
	private String locality;
	private String email;
	private String name;
	
	
	public Customer() {
		super();
	}
	public Customer(String password, String mobile, String pcode, String country, String zip, String state,
			String address, String locality, String email, String name) {
		super();
		this.Password = password;
		this.mobile = mobile;
		this.pcode = pcode;
		this.country = country;
		this.zip = zip;
		this.state = state;
		this.address = address;
		this.locality = locality;
		this.email = email;
		this.name = name;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [Password=" + Password + ", mobile=" + mobile + ", pcode=" + pcode + ", country=" + country
				+ ", zip=" + zip + ", state=" + state + ", address=" + address + ", locality=" + locality + ", email="
				+ email + ", name=" + name + "]";
	}
	
	
}
