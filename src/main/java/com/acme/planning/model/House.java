package com.acme.planning.model;

public class House {

	private String id;
	private DayOfWeek dayOfWeek;
	private Location houseLocation;

	public House(String id, DayOfWeek dayOfWeek, Location houseLocation) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.houseLocation = houseLocation;
	}

	public House(String id, DayOfWeek dayOfWeek) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Location getHouseLocation() {
		return houseLocation;
	}

	public void setHouseLocation(Location houseLocation) {
		this.houseLocation = houseLocation;
	}

}
