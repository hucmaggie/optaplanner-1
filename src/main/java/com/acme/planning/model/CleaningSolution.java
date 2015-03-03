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
@XStreamAlias("CleaningSolution")
public class CleaningSolution extends AbstractPersistable implements
		Solution<HardSoftScore> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private List<Cleaner> cleanerList;
	private List<House> houseToCleanList;


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

}
