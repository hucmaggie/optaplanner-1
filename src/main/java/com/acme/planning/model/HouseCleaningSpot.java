package com.acme.planning.model;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;


@PlanningEntity
public class HouseCleaningSpot {

	private House house;
	private int cleaningSpotIndex;

	private Cleaner cleaner;

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public int getCleaningSpotIndex() {
		return cleaningSpotIndex;
	}

	public void setCleaningSpotIndex(int cleaningSpotIndex) {
		this.cleaningSpotIndex = cleaningSpotIndex;
	}

	@PlanningVariable
	public Cleaner getCleaner() {
		return cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

}
