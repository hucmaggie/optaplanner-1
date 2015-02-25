package com.acme.planning.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import com.thoughtworks.xstream.annotations.XStreamAlias;




@PlanningSolution
@XStreamAlias("CleaningPlan")
public class CleaningPlan extends AbstractPersistable implements Solution<HardSoftScore> {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */

	private List<Cleaner> cleanerList;
	private List<House> houseToCleanList;
	
    //@XStreamConverter(value = XStreamScoreConverter.class, types = {HardSoftScoreDefinition.class})
    private HardSoftScore score;

	public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(houseToCleanList);
        return facts;
	}

	public HardSoftScore getScore() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setScore(HardSoftScore arg0) {
		// TODO Auto-generated method stub
		
	}

	@PlanningEntityCollectionProperty
	public List<Cleaner> getCleanerList() {
		return cleanerList;
	}

	public void setCleanerList(List<Cleaner> cleanerList) {
		this.cleanerList = cleanerList;
	}

	@ValueRangeProvider(id = "houseRange")
	public List<House> getHouseToCleanList() {
		return houseToCleanList;
	}

	public void setHouseToCleanList(List<House> houseToCleanList) {
		this.houseToCleanList = houseToCleanList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cleanerList == null) ? 0 : cleanerList.hashCode());
		result = prime
				* result
				+ ((houseToCleanList == null) ? 0 : houseToCleanList.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CleaningPlan other = (CleaningPlan) obj;
		if (cleanerList == null) {
			if (other.cleanerList != null)
				return false;
		} else if (!cleanerList.equals(other.cleanerList))
			return false;
		if (houseToCleanList == null) {
			if (other.houseToCleanList != null)
				return false;
		} else if (!houseToCleanList.equals(other.houseToCleanList))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}


}
