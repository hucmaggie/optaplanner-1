package com.acme.planning.model;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;


@PlanningEntity
public class HouseCleaningSpot {

	private Long id;
	private House house;
	private int cleaningSpotIndex;

	private Cleaner cleaner;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@PlanningVariable(valueRangeProviderRefs = {"cleanerRange"})
	public Cleaner getCleaner() {
		return cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

}
