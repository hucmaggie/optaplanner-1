package com.acme.planning.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class CleaningSolution implements Serializable, Solution<HardSoftScore> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HardSoftScore score;

	private List<Cleaner> cleanerList;
	private List<HouseCleaningSpot> houseCleaningSpotList;
	private List<House> houseList;

	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}

	public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(cleanerList);
        //facts.addAll(houseList);
        return facts;
	}

	@ValueRangeProvider(id = "cleanerRange")
	public List<Cleaner> getCleanerList() {
		return cleanerList;
	}

	public void setCleanerList(List<Cleaner> cleanerList) {
		this.cleanerList = cleanerList;
	}

	@PlanningEntityCollectionProperty
	public List<HouseCleaningSpot> getHouseCleaningSpotList() {
		return houseCleaningSpotList;
	}

	public void setHouseCleaningSpotList(
			List<HouseCleaningSpot> houseCleaningSpotList) {
		this.houseCleaningSpotList = houseCleaningSpotList;
	}

	public List<House> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}

}
