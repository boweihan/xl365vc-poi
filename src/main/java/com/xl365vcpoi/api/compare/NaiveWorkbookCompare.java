package com.xl365vcpoi.api.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.xl365vcpoi.api.service.ExcelWorkbookUtility;

@Component
public class NaiveWorkbookCompare implements ExcelCompareStrategy {

	@Autowired
	private ExcelWorkbookUtility excelWorkbookUtility;
	
	@Override
	public ExcelCompareResult compare(XSSFWorkbook source, XSSFWorkbook copy) {
		Set<String> sourceSheets = excelWorkbookUtility.getSheetNames(source);
		Set<String> copySheets = excelWorkbookUtility.getSheetNames(copy);
		
		Set<String> removedSheets = Sets.difference(sourceSheets, copySheets);
		Set<String> addedSheets = Sets.difference(copySheets, sourceSheets);
		
		// TODO: refactor ExcelCompareResult
		List<String> sheetDifferences = new ArrayList<>();
		removedSheets.forEach(sheet -> {
			sheetDifferences.add("Removed: " + sheet);
		});
		addedSheets.forEach(sheet -> {
			sheetDifferences.add("Added: " + sheet);
		});
		
		Set<String> commonSheets = Sets.union(sourceSheets, copySheets);

		for (Sheet sheet : source) {
//			if (sheet.getSheetName())
		}
		
		return new ExcelCompareResult(sheetDifferences);
	}
}
