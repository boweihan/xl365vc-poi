package com.xl365vcpoi.api.compare;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExcelCompareStrategy {
	public ExcelCompareResult compare(XSSFWorkbook source, XSSFWorkbook reference);
}
