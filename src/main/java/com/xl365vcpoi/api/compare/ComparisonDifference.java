package com.xl365vcpoi.api.compare;

import com.xl365vcpoi.api.helper.Difference;

public class ComparisonDifference {
	private String identifier;
	private Difference difference;
	
	public ComparisonDifference(String identifier, Difference difference) {
		this.setIdentifier(identifier);
		this.setDifference(difference);
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Difference getDifference() {
		return difference;
	}

	public void setDifference(Difference difference) {
		this.difference = difference;
	}
}
