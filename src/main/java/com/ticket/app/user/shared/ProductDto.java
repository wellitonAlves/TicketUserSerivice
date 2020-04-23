package com.ticket.app.user.shared;

import java.io.Serializable;

public class ProductDto implements Serializable{

	private static final long serialVersionUID = -1344826460327335118L;
	
	private String eventName;
	private String place;
	private String price;
	private String id;
	private String Userid;
	
	
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
