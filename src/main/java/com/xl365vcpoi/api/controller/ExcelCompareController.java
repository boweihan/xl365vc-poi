package com.xl365vcpoi.api.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xl365vcpoi.api.exception.InvalidEntityException;
import com.xl365vcpoi.api.service.ExcelCompareService;
import com.xl365vcpoi.api.service.ExcelFileService;

@RestController
public class ExcelCompareController {

	private static final Logger logger = LoggerFactory.getLogger(ExcelCompareController.class);
	
	@Autowired
	private ExcelCompareService excelCompareService;
	
	@Autowired
	private ExcelFileService excelFileService;
	
    @PostMapping("/compare")
    public String compareExcelFiles(@RequestParam("files") MultipartFile[] files) {
        List<XSSFWorkbook> excelFiles = Arrays.asList(files)
                .stream()
                .map(file -> excelFileService.reifyExcelWorkbook(file))
                .collect(Collectors.toList());

        excelFiles.removeAll(Collections.singleton(null));

        if (excelFiles.size() != 2) {
        	throw new InvalidEntityException("There must be exactly two excel files to compare");
        }
        excelCompareService.compareFiles(excelFiles);
        return "boop";
    }
}
