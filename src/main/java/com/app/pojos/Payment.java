package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment extends BaseEntity {

	private String cardNo;
	private String name;
	private String expDate;
	private String cvv;
	private String amount;
	public Payment() {
		super();
	}
	public Payment(String cardNo, String name, String expDate, String cvv, String amount) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.expDate = expDate;
		this.cvv = cvv;
		this.amount = amount;
	}
	public Payment(String cardNo2, String name2, String expDate2, String cvv2) {
		this.cardNo = cardNo2;
		this.name = name2;
		this.expDate = expDate2;
		this.cvv = cvv2;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [cardNo=" + cardNo + ", name=" + name + ", expDate=" + expDate + ", cvv=" + cvv + ", amount="
				+ amount + "]";
	}
	
}
