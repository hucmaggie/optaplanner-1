package com.acme.planning.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("House")
public class House extends AbstractPersistable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8792399274437960066L;
	private String houseName;
	private Integer houseId;
	private Address address;
	private String houseType;
	private int requiredCleaners;
	private Location houseLocation;

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public int getRequiredCleaners() {
		return requiredCleaners;
	}

	public void setRequiredCleaners(int requiredCleaners) {
		this.requiredCleaners = requiredCleaners;
	}

	public Location getHouseLocation() {
		return houseLocation;
	}

	public void setHouseLocation(Location houseLocation) {
		this.houseLocation = houseLocation;
	}

}
