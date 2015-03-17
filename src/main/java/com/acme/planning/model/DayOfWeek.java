package com.acme.planning.model;

public class DayOfWeek {
	private String dayId;

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

}
