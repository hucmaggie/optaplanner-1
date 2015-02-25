package com.acme.planning.model;


public class Address extends AbstractPersistable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String streetName;
private String doorNumber;
private String city;
private String zip;
private String state;
private String country;
public String getStreetName() {
	return streetName;
}
public void setStreetName(String streetName) {
	this.streetName = streetName;
}
public String getDoorNumber() {
	return doorNumber;
}
public void setDoorNumber(String doorNumber) {
	this.doorNumber = doorNumber;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
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
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
}
