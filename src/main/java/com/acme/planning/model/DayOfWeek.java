package com.acme.planning.model;

public class DayOfWeek {
	private Long id;
	private String dayId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDayId() {
		return dayId;
	}

	public void setDayId(String dayId) {
		this.dayId = dayId;
	}

	public DayOfWeek(String dayId) {
		super();
		this.dayId = dayId;
	}

	public DayOfWeek(Long id, String dayId) {
		super();
		this.id = id;
		this.dayId = dayId;
	}

}
