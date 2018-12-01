package com.xl365vcpoi.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xl365vcpoi.api.service.ExcelCompareService;
import com.xl365vcpoi.api.service.ExcelValidationService;

@RestController
public class ExcelCompareController {

	private static final Logger logger = LoggerFactory.getLogger(ExcelCompareController.class);
	
	@Autowired
	private ExcelCompareService excelCompareService;
	private ExcelValidationService excelValidationService;
	
    @PostMapping("/uploadMultipleFiles")
    public void uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        List<MultipartFile> excelFiles = Arrays.asList(files)
                .stream()
                .collect(Collectors.toList());
        
        excelValidationService.reifyExcelFiles(excelFiles);
        excelCompareService.compareFiles(excelFiles);
    }
}
