package com.acme.planning.model;

public class Cleaner {

	private int id;
	private DayOfWeek dayOfWeek;
	private Location cleanerLocation;

	public Cleaner(int id, DayOfWeek dayOfWeek, Location cleanerLocation) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.cleanerLocation = cleanerLocation;
	}

	public Cleaner(int id, DayOfWeek dayOfWeek) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Location getCleanerLocation() {
		return cleanerLocation;
	}

	public void setCleanerLocation(Location cleanerLocation) {
		this.cleanerLocation = cleanerLocation;
	}

}
