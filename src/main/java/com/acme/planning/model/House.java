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
	private String houseType;
	private int requiredCleaners;
	private Location houseLocation;
	private DayOfWeek dayOfWeek;
	private Cleaner cleaner;

	public Cleaner getCleaner() {
		return cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

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

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

}
