package com.xl365vcpoi.api.compare;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCompareContext {
	private ExcelCompareStrategy strategy;
	
	public ExcelCompareContext(ExcelCompareStrategy strategy) {
		this.strategy = strategy;
	}
	
	public ExcelCompareResult executeStrategy(XSSFWorkbook source, XSSFWorkbook reference) {
		return strategy.compare(source, reference);
	}
}
