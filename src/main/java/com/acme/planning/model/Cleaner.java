package com.acme.planning.model;

public class Cleaner {

	private Long id;
	private DayOfWeek dayOfWeek;
	private Location cleanerLocation;




	public Cleaner() {
		super();
	}

	public Cleaner(Long id, DayOfWeek dayOfWeek) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
