package com.xl365vcpoi.api.compare;

import java.util.List;

public class ExcelCompareResult {
	private List<String> differences;
	
	public ExcelCompareResult(List<String> differences) {
		this.setDifferences(differences);
	}

	public List<String> getDifferences() {
		return differences;
	}

	public void setDifferences(List<String> differences) {
		this.differences = differences;
	}
}
