package com.acme.planning.model;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.acme.planning.util.CleanerDifficultyComparator;
import com.acme.planning.util.HouseStrengthComparator;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@PlanningEntity(difficultyComparatorClass = CleanerDifficultyComparator.class)
@XStreamAlias("Cleaner")
public class Cleaner extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	//planning variable
	private House house;
	private Location cleanerLocation;
	private String home;
	
	
    @PlanningVariable(valueRangeProviderRefs = {"houseRange", "cleanerRange"}, strengthComparatorClass = HouseStrengthComparator.class)
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
    public String getLabel() {
        return "Cleaner " + id;
    }
	

    @Override
    public String toString() {
        return getLabel() + "->" + house;
    }
	public Location getCleanerLocation() {
		return cleanerLocation;
	}
	public void setCleanerLocation(Location cleanerLocation) {
		this.cleanerLocation = cleanerLocation;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}

}
