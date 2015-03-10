package com.acme.planning.model;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;


@PlanningEntity
public class House {
	private DayOfWeek dayOfWeek;
	private Location houseLocation;

	
	@PlanningVariable
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
