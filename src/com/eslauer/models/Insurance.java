package com.eslauer.models;

// Generated Apr 10, 2015 11:34:20 AM by Hibernate Tools 3.4.0.CR1

/**
 * Insurance generated by hbm2java
 */
public class Insurance implements java.io.Serializable {

	private Integer idinsurance;
	private String name;

	public Insurance() {
	}

	public Insurance(String name) {
		this.name = name;
	}

	public Integer getIdinsurance() {
		return this.idinsurance;
	}

	public void setIdinsurance(Integer idinsurance) {
		this.idinsurance = idinsurance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
