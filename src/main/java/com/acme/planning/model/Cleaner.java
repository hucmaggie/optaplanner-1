package com.acme.planning.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.acme.planning.util.CleanerDifficultyComparator;
import com.acme.planning.util.HouseStrengthComparator;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@PlanningEntity(difficultyComparatorClass = CleanerDifficultyComparator.class)
@XStreamAlias("Cleaner")
public class Cleaner extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	//planning variable
	private House house;
	
	
    @PlanningVariable(valueRangeProviderRefs = {"houseRange"}, strengthComparatorClass = HouseStrengthComparator.class)
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
    public String getLabel() {
        return "Cleaner " + id;
    }
	
	public boolean solutionEquals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Cleaner) {
        	Cleaner other = (Cleaner) o;
            return new EqualsBuilder()
                    .append(id, other.id)
                    .append(house, other.house)
                    .isEquals();
        } else {
            return false;
        }
    }

    /**
     * The normal methods {@link #equals(Object)} and {@link #hashCode()} cannot be used because the rule engine already
     * requires them (for performance in their original state).
     * @see #solutionEquals(Object)
     */
    public int solutionHashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(house)
                .toHashCode();
    }

    @Override
    public String toString() {
        return getLabel() + "->" + house;
    }

}
