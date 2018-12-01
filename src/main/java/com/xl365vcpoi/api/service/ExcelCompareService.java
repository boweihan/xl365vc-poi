package com.xl365vcpoi.api.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.xl365vcpoi.api.compare.ExcelCompareContext;
import com.xl365vcpoi.api.compare.NaiveCellCompare;
import com.xl365vcpoi.api.helper.Pair;

@Service
public class ExcelCompareService {

	public void compareFiles(Pair<XSSFWorkbook, XSSFWorkbook> excelFilePair) {
		ExcelCompareContext context = new ExcelCompareContext(new NaiveCellCompare());
		context.executeStrategy(excelFilePair.first, excelFilePair.second);
	}

}
