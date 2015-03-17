package com.acme.planning.model;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.acme.planning.util.CleaningHouseDifficultyComparator;


@PlanningEntity(difficultyComparatorClass = CleaningHouseDifficultyComparator.class)
public class HouseCleaningSpot {

	/**
	 * 
	 */
	private Long id;
	private House house;
	private int cleaningSpotIndex;

	//planning variable
	private Cleaner cleaner;

	
	
	public HouseCleaningSpot() {
		super();
	}

	public HouseCleaningSpot(Long id, House house, int cleaningSpotIndex) {
		super();
		this.id = id;
		this.house = house;
		this.cleaningSpotIndex = cleaningSpotIndex;
	}

	public HouseCleaningSpot(House house, int cleaningSpotIndex) {
		super();
		this.house = house;
		this.cleaningSpotIndex = cleaningSpotIndex;
	}

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

	@PlanningVariable(valueRangeProviderRefs = "cleanerRange")
	public Cleaner getCleaner() {
		return cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

}
