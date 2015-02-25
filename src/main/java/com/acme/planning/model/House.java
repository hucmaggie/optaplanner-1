package com.acme.planning.model;


public class House extends AbstractPersistable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 8792399274437960066L;
	private String houseName;
	private Integer houseId;
	private Address address;
	private String houseType;
	private int requiredCleaners;
}
