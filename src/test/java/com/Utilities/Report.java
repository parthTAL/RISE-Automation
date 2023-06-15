package com.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;



public class Report {
	
	public ExtentSparkReporter reporter; 
	public ExtentReports extent;
	public ExtentTest test;
	

	
	public Report() {
		
	reporter = new ExtentSparkReporter("Report.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);

	
	}
	
	
	public void flush() {
		extent.flush();
	}

	
	public void newTest(String test_name) {
		
		
		test = extent.createTest(test_name);
		
	}
	

public void log_pass(String details, String filename) {
		
		
		test.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(filename).build());
		System.out.println("pass: " + filename);
		
	}

public void log_fail(String details, String filename) {
	
	
	test.fail(details, MediaEntityBuilder.createScreenCaptureFromPath(filename).build());
	System.out.println("fail: " + filename);
	
}


public void log_info(String details) {
	
	
	test.info(details);
	
}



	
}
