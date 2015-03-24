package com.acme.planning.util;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.lang.builder.CompareToBuilder;

import com.acme.planning.model.HouseCleaningSpot;

public class CleaningHouseDifficultyComparator implements Comparator<HouseCleaningSpot>, Serializable {

    /**dsdsds
	 * dsddsdsds
	 */
	private static final long serialVersionUID = 1L;

	public int compare(HouseCleaningSpot a, HouseCleaningSpot b) {
        return new CompareToBuilder()
                // TODO experiment with (aLatitude - bLatitude) % 10
                .append(a.getId(), b.getId())
                .toComparison();
    }

}
